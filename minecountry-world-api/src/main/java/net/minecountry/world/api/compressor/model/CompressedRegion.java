package net.minecountry.world.api.compressor.model;

import java.util.HashMap;
import java.util.Map;

public class CompressedRegion {
    private final Map<Short, CompressedChunk> chunks;

    public CompressedRegion() {
        this.chunks = new HashMap<>();
    }

    public CompressedRegion(Map<Short, CompressedChunk> chunks) {
        this.chunks = chunks;
    }

    public Map<Short, CompressedChunk> getChunks() {
        return chunks;
    }

    public void addChunk(short index, CompressedChunk chunk) {
        chunks.put(index, chunk);
    }
}
