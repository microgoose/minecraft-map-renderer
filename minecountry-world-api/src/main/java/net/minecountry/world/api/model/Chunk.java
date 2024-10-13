package net.minecountry.world.api.model;

import net.minecountry.world.api.config.ChunkConfig;

public class Chunk {
    private final int chunkX;
    private final int chunkY;
    private final Block[] blocks = new Block[ChunkConfig.BLOCKS_COUNT];

    public Chunk(int chunkX, int chunkY) {
        this.chunkX = chunkX;
        this.chunkY = chunkY;
    }

    public int getChunkX() {
        return chunkX;
    }

    public int getChunkY() {
        return chunkY;
    }

    public Block getBlock(int index) {
        return blocks[index];
    }

    public void setBlock(int index, Block block) {
        blocks[index] = block;
    }

    public Block[] getBlocks() {
        return blocks;
    }
}
