package net.minecountry.world.io;

import net.minecountry.world.api.compressor.model.CompressedChunk;
import net.minecountry.world.api.compressor.model.CompressedRegion;
import net.minecountry.world.api.structure.config.ChunkConfig;
import net.minecountry.world.api.structure.model.Point;
import net.minecountry.world.io.config.RegionIOConfig;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class RegionWriter {
    private final Path destination;

    public RegionWriter(Path destination) {
        this.destination = destination;
    }

    public void write(Point regionPoint, CompressedRegion region) {
        Path filePath = destination.resolve(getRegionFileName(regionPoint));
        ByteBuffer buffer = regionToBytes(region);
        byte[] data = buffer.array();

        try {
            Files.write(filePath, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String getRegionFileName(Point regionPoint) {
        return String.format("region.%d.%d.dat", regionPoint.getX(), regionPoint.getY());
    }

    private ByteBuffer regionToBytes(CompressedRegion region) {
        Map<Short, CompressedChunk> chunks = region.getChunks();
        int chunkIndicesByteSize = chunks.size() * 2;
        int chunkByteSize = chunks.size() * RegionIOConfig.CHUNK_BYTE_SIZE;
        int totalSize = chunkIndicesByteSize + chunkByteSize;

        ByteBuffer buffer = ByteBuffer.allocate(totalSize);
        buffer.order(ByteOrder.BIG_ENDIAN);

        for (Map.Entry<Short, CompressedChunk> entry : chunks.entrySet()) {
            buffer.putShort(entry.getKey());
            buffer.put(chunkToBytes(entry.getValue()));
        }

        return buffer;
    }

    private ByteBuffer chunkToBytes(CompressedChunk chunk) {
        ByteBuffer buffer = ByteBuffer.allocate(RegionIOConfig.CHUNK_BYTE_SIZE);
        buffer.order(ByteOrder.BIG_ENDIAN);

        for (short index = 0; index < ChunkConfig.CHUNK_MAX_BLOCKS_COUNT; index++) {
            buffer.putShort(chunk.getBlockTypes()[index]);
            buffer.putShort(chunk.getBlockHeights()[index]);

            buffer.putShort(chunk.getWaterDepth()[index]);

            buffer.putShort(chunk.getPlantTypes()[index]);
            buffer.putShort(chunk.getPlantHeight()[index]);
        }

        for (short index = 0; index < chunk.getWaterLayer().length; index++) {
            buffer.put(chunk.getWaterLayer()[index]);
        }

        return buffer;
    }
}
