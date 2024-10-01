package net.minecraft.world.api.structure.model;

import net.minecraft.world.api.structure.registries.BlockTypes;

public class Block {
    public final int x;
    public final int y;
    public final short height;
    public final BlockTypes blockTypes;

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
