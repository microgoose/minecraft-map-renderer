package net.world.map.structure.model;

public class Block {
    public final int x;
    public final int y;
    public final short height;
    public final String blockType;

    public Block(int x, int y, short height, String blockType) {
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

    public String getBlockType() {
        return blockType;
    }
}
