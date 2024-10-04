package net.minecraft.world.api.structure.model;

import net.minecraft.world.api.structure.config.ChunkConfig;

public class Chunk {
    private final int x;
    private final int y;
    private final Block[] blocks = new Block[ChunkConfig.CHUNK_MAX_BLOCKS_COUNT];

    public Chunk(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBlockLocalX(int x) {
        return Math.floorMod(x, ChunkConfig.CHUNK_SIZE);
    }

    public int getBlockLocalY(int y) {
        return Math.floorMod(y, ChunkConfig.CHUNK_SIZE);
    }

    public Block getBlockByLocal(int localX, int localY) {
        return blocks[localX * ChunkConfig.CHUNK_SIZE + localY];
    }

    public Block getBlockAt(int x, int y) {
        return getBlockByLocal(getBlockLocalX(x), getBlockLocalY(y));
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public void addBlockByLocal(int localX, int localY, Block block) {
        blocks[localX * ChunkConfig.CHUNK_SIZE + localY] = block;
    }

    public void addBlock(Block block) {
        addBlockByLocal(getBlockLocalX(block.getX()), getBlockLocalX(block.getY()), block);
    }
}
