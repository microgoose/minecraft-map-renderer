package net.minecountry.world.api.structure.model;

import net.minecountry.world.api.structure.registries.BlockTypes;

public class Block {
    private final int x;
    private final int y;
    private final short height;
    private final BlockTypes blockTypes;

    public Block(int x, int y, short height, BlockTypes blockTypes) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.blockTypes = blockTypes;
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

    public BlockTypes getBlockType() {
        return blockTypes;
    }
}
