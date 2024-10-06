package net.minecountry.world.api.structure.model;

public class BlockData {
    private final short height;
    private final short blockTypes;

    public BlockData(short height, short blockTypes) {
        this.height = height;
        this.blockTypes = blockTypes;
    }

    public short getHeight() {
        return height;
    }

    public short getBlockTypes() {
        return blockTypes;
    }
}
