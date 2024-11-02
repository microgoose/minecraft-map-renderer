package net.minecountry.model;

public class LayeredBlock extends Block {
    private final short[] heights;
    private final short[] types;

    public LayeredBlock(int x, int y, short height, short type, short[] heights, short[] types) {
        super(x, y, height, type);
        this.heights = heights;
        this.types = types;
    }

    public short[] getHeights() {
        return heights;
    }

    public short[] getTypes() {
        return types;
    }
}
