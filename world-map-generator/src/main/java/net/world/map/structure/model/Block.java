package net.world.map.structure.model;

public class Block {
    public final int x;
    public final int y;
    public final int height;
    public final int rgb;

    public Block(int x, int y, int height, int rgb) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.rgb = rgb;
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

    public int getRgb() {
        return rgb;
    }
}
