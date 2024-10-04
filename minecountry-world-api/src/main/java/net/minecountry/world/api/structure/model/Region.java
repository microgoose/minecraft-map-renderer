package net.minecountry.world.api.structure.model;

import net.minecountry.world.api.structure.config.ChunkConfig;
import net.minecountry.world.api.structure.config.RegionConfig;

import java.util.HashMap;
import java.util.Map;

public class Region {
    private final int x;
    private final int y;
    private final Map<Integer, Chunk> chunks = new HashMap<>();

    public Region(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Block getBlockAt(int x, int y) {
        Chunk chunk = getChunkAt(x, y);

        if (chunk == null)
            return null;

        return chunk.getBlockAt(x, y);
    }

    public int getChunkLocalX(int x) {
        return Math.floorMod(x, RegionConfig.REGION_SIZE);
    }

    public int getChunkLocalY(int y) {
        return Math.floorMod(y, RegionConfig.REGION_SIZE);
    }

    public Chunk getChunkByLocal(int localX, int localY) {
        return chunks.get(localX * RegionConfig.REGION_SIZE + localY);
    }

    public Chunk getChunkAt(int x, int y) {
        int chunkX = Math.floorDiv(x, ChunkConfig.CHUNK_SIZE);
        int chunkY = Math.floorDiv(y, ChunkConfig.CHUNK_SIZE);
        return getChunkByLocal(getChunkLocalX(chunkX), getChunkLocalY(chunkY));
    }

    public Chunk getChunkByIndex(int index) {
        return chunks.get(index);
    }

    public Map<Integer, Chunk> getChunks() {
        return chunks;
    }

    public void addChunkByLocal(int x, int y, Chunk chunk) {
        chunks.put(x * RegionConfig.REGION_SIZE + y, chunk);
    }

    public void addChunk(Chunk chunk) {
        addChunkByLocal(getChunkLocalX(chunk.getX()), getChunkLocalY(chunk.getY()), chunk);
    }
}
