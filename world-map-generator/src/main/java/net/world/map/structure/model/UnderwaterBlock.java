package net.world.map.structure.model;

public class UnderwaterBlock extends Block {
    public int depth;

    public UnderwaterBlock(int x, int y, int height, int depth, int rgb) {
        super(x, y, height, rgb);
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
}
