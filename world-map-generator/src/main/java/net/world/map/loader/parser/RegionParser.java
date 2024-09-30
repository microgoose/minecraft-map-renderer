package net.world.map.loader.parser;

import net.querz.mca.CompressionType;
import net.querz.nbt.io.NBTInputStream;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.Tag;
import net.world.map.structure.config.RegionConfig;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.Region;

import java.io.*;
import java.util.Optional;

public class RegionParser {
    public static Optional<Chunk> parseChunk(RandomAccessFile raf, int index) throws IOException {
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

    public static Optional<Region> parse(File regionFile) throws IOException {
        String[] parts = regionFile.getName().split("\\.");
        int x = Integer.parseInt(parts[1]);
        int z = Integer.parseInt(parts[2]);
        Region region = new Region(x, z);

        try (RandomAccessFile raf = new RandomAccessFile(regionFile, "r")) {
            for (int i = 0; i < RegionConfig.REGION_MAX_CHUNKS_COUNT; i++) {
                Optional<Chunk> chunk = parseChunk(raf, i);
                chunk.ifPresent(region::addChunk);
            }
        }

        if (region.getChunks().isEmpty())
            return Optional.empty();

        return Optional.of(region);
    }
}