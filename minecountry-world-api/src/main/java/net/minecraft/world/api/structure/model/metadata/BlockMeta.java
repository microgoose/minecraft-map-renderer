package net.minecraft.world.api.structure.model.metadata;

public abstract class BlockMeta {
    public Class<? extends BlockMeta> getType() {
        return this.getClass();
    }
}
