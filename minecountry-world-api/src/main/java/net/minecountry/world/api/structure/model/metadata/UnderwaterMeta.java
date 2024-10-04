package net.minecountry.world.api.structure.model.metadata;

public class UnderwaterMeta extends BlockMeta {
    public short depth = 1;

    public short getDepth() {
        return depth;
    }

    public void setDepth(short depth) {
        this.depth = depth;
    }

    public void incrementDepth() {
        this.depth++;
    }

    public void decrementDepth() {
        this.depth--;
    }
}
