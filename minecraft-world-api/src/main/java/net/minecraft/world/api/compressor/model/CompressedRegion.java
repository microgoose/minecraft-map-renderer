package net.minecraft.world.api.compressor.model;

import java.util.HashMap;
import java.util.Map;

public class CompressedRegion {
    private final Map<Short, CompressedChunk> chunks = new HashMap<>();

    public Map<Short, CompressedChunk> getChunks() {
        return chunks;
    }

    public void addChunk(short index, CompressedChunk chunk) {
        chunks.put(index, chunk);
    }
}
