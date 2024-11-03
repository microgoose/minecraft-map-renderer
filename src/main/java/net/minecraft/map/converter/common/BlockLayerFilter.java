package net.minecraft.map.converter.common;

import net.minecraft.map.core.registries.BlockType;

import java.util.Optional;

public interface BlockLayerFilter {
    Optional<BlockType> shouldAddToLayer(BlockType type);
}
