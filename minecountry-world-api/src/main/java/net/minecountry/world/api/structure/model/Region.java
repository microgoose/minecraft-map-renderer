package net.minecountry.world.api.structure.model;

import net.minecountry.world.api.structure.config.RegionConfig;

public class Region {
    private final int regionX;
    private final int regionY;
    private final Chunk[] chunks = new Chunk[RegionConfig.CHUNKS_COUNT];

    public Region(int regionX, int regionY) {
        this.regionX = regionX;
        this.regionY = regionY;
    }

    public int getRegionX() {
        return regionX;
    }

    public int getRegionY() {
        return regionY;
    }

    public Chunk getChunk(int index) {
        return chunks[index];
    }

    public void setChunk(int index, Chunk chunk) {
        chunks[index] = chunk;
    }

    public Chunk[] getChunks() {
        return chunks;
    }
}
