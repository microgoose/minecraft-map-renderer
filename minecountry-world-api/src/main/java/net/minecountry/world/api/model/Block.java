package net.minecountry.world.api.model;

public class Block {
    private final int x;
    private final int y;
    private final short height;
    private final short type;

    public Block(int x, int y, short height, short type) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.type = type;
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

    public short getBlockType() {
        return type;
    }
}
