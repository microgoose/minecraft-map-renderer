package net.minecountry.world.io.dat.model;

import java.util.HashMap;
import java.util.Map;

public class CompressedRegion {
    private final Map<Short, CompressedChunk> chunks = new HashMap<>();

    public void addChunk(short index, CompressedChunk chunk) {
        chunks.put(index, chunk);
    }
}