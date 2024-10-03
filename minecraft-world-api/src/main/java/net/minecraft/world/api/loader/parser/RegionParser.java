package net.minecraft.world.api.loader.parser;

import net.minecraft.world.api.structure.config.RegionConfig;
import net.minecraft.world.api.structure.model.Chunk;
import net.minecraft.world.api.structure.model.Point;
import net.minecraft.world.api.structure.model.Region;
import net.querz.mca.CompressionType;
import net.querz.nbt.io.NBTInputStream;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.Tag;

import java.io.*;
import java.nio.file.Path;
import java.util.Optional;

public class RegionParser {
    public static Point getRegionPoint(String regionName) {
        String[] parts = regionName.split("\\.");
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        return new Point(x, y);
    }

    public static Optional<Region> parse(File regionFile) {
        Point regionPoint = getRegionPoint(regionFile.getName());
        Region region = new Region(regionPoint.getX(), regionPoint.getY());

        try (RandomAccessFile raf = new RandomAccessFile(regionFile, "r")) {
            for (int i = 0; i < RegionConfig.REGION_MAX_CHUNKS_COUNT; i++) {
                Optional<Chunk> chunk = parseChunk(raf, i);
                chunk.ifPresent(region::addChunk);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if (region.getChunks().isEmpty())
            return Optional.empty();

        return Optional.of(region);
    }

    public static Optional<Region> parse(Path regionPath) {
        return parse(regionPath.toFile());
    }

    private static Optional<Chunk> parseChunk(RandomAccessFile raf, int index) throws IOException {
        raf.seek(index * 4L);
        int offset = raf.read() << 16;
        offset |= (raf.read() & 0xFF) << 8;
        offset |= raf.read() & 0xFF;

        if (raf.readByte() == 0) {
            return Optional.empty();
        }

        raf.seek(4096L * offset + 4); // +4 skip chunk size

        byte compressionTypeByte = raf.readByte();
        CompressionType compressionType = CompressionType.getFromID(compressionTypeByte);

        if (compressionType == null) {
            throw new IOException("Invalid compression type " + compressionTypeByte);
        }

        DataInputStream dis = new DataInputStream(new BufferedInputStream(
                compressionType.decompress(new FileInputStream(raf.getFD()))
        ));

        NamedTag tag = new NBTInputStream(dis).readTag(Tag.DEFAULT_MAX_DEPTH);

        if (tag != null && tag.getTag() instanceof CompoundTag chunkTag) {
            return ChunkParser.parse(chunkTag);
        } else {
            throw new IOException("Invalid data tag: " + (tag == null ? "null" : tag.getName()));
        }
    }
}