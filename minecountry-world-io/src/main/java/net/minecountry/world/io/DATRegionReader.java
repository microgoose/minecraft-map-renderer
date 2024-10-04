package net.minecountry.world.io;

import net.minecountry.world.api.compressor.model.CompressedChunk;
import net.minecountry.world.api.compressor.model.CompressedRegion;
import net.minecountry.world.api.structure.config.ChunkConfig;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class DATRegionReader {
    public CompressedRegion read(Path regionFile) {
        try {
            byte[] data = Files.readAllBytes(regionFile);
            ByteBuffer buffer = ByteBuffer.wrap(data);
            buffer.order(ByteOrder.BIG_ENDIAN);

            return bytesToRegion(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CompressedRegion bytesToRegion(ByteBuffer buffer) {
        CompressedRegion region = new CompressedRegion();
        Map<Short, CompressedChunk> chunks = new HashMap<>();

        while (buffer.hasRemaining()) {
            short chunkIndex = buffer.getShort();
            CompressedChunk chunk = bytesToChunk(buffer);
            chunks.put(chunkIndex, chunk);
        }
//TODO
//        region.setChunks(chunks);
        return region;
    }

    private CompressedChunk bytesToChunk(ByteBuffer buffer) {
        CompressedChunk chunk = new CompressedChunk();

        for (short index = 0; index < ChunkConfig.CHUNK_MAX_BLOCKS_COUNT; index++) {
            short blockType = buffer.getShort();
            short blockHeight = buffer.getShort();

            short waterDepth = buffer.getShort();

            short plantType = buffer.getShort();
            short plantHeight = buffer.getShort();

            chunk.setBlockLayer(index, blockType, blockHeight);
            chunk.setWaterLayer(index, waterDepth);
            chunk.setPlantLayer(index, plantType, plantHeight);
        }

        byte[] waterLayer = new byte[32];
        for (short index = 0; index < waterLayer.length; index++) {
            waterLayer[index] = buffer.get();
        }
//TODO
//        chunk.setWaterLayer(waterLayer);

        return chunk;
    }
}
