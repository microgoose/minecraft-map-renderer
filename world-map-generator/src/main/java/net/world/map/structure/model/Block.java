package net.world.map.structure.model;

import net.world.map.structure.collecions.BlockType;

public class Block {
    public final int x;
    public final int y;
    public final short height;
    public final BlockType blockType;

    public Block(int x, int y, short height, BlockType blockType) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.blockType = blockType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public BlockType getBlockType() {
        return blockType;
    }
}
