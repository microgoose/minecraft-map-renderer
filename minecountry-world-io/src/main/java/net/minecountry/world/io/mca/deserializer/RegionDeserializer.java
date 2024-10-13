package net.minecountry.world.io.mca.deserializer;

import net.minecountry.world.api.common.Point;
import net.minecountry.world.api.config.RegionConfig;
import net.minecountry.world.api.model.Chunk;
import net.minecountry.world.api.model.Region;
import net.querz.mca.CompressionType;
import net.querz.nbt.io.NBTInputStream;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.Tag;

import java.io.*;
import java.util.Optional;

public class RegionDeserializer {
    private final ChunkDeserializer chunkDeserializer;

    public RegionDeserializer(ChunkDeserializer chunkDeserializer) {
       this.chunkDeserializer = chunkDeserializer;
    }

    public Optional<Region> deserialize(File regionFile) {
        String[] parts = regionFile.getName().split("\\.");
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        Point regionPoint = new Point(x, y);
        Region region = new Region(regionPoint.getX(), regionPoint.getY());

        try (RandomAccessFile raf = new RandomAccessFile(regionFile, "r")) {
            for (int index = 0; index < RegionConfig.CHUNKS_COUNT; index++) {
                Optional<Chunk> chunk = deserializeChunk(raf, index);

                if (chunk.isPresent())
                    region.setChunk(index, chunk.get());
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if (region.getChunks().length == 0)
            return Optional.empty();

        return Optional.of(region);
    }

    private Optional<Chunk> deserializeChunk(RandomAccessFile raf, int index) throws IOException {
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
            return chunkDeserializer.deserialize(chunkTag);
        } else {
            throw new IOException("Invalid data tag: " + (tag == null ? "null" : tag.getName()));
        }
    }
}