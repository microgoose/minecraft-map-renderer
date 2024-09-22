package net.world.map.structure.model;

public class UnderwaterBlock extends Block {
    public int depth;

    public UnderwaterBlock(int x, int y, short height, int depth, String blockType) {
        super(x, y, height, blockType);
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
}