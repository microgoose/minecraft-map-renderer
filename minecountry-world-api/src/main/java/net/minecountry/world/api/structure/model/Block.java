package net.minecountry.world.api.structure.model;

import net.minecountry.world.api.structure.registries.BlockType;

public class Block {
    private final int x;
    private final int y;
    private final short height;
    private final BlockType blockType;

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

    public short getHeight() {
        return height;
    }

    public BlockType getBlockType() {
        return blockType;
    }
}
