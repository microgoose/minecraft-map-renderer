package net.minecountry.world.io.mca.common;

import net.minecountry.world.api.registries.BlockType;

import java.util.Optional;

public interface BlockLayerFilter {
    Optional<BlockType> shouldAddToLayer(BlockType type);
}
