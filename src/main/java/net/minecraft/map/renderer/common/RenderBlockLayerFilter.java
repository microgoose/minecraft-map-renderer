package net.minecraft.map.renderer.common;

import net.minecraft.map.converter.common.BlockLayerFilter;
import net.minecraft.map.core.registries.BlockType;
import net.minecraft.map.core.registries.PlantBlockRegistry;

import java.util.Optional;

public class RenderBlockLayerFilter implements BlockLayerFilter {
    @Override
    public Optional<BlockType> shouldAddToLayer(BlockType type) {
        if (type.equals(BlockType.WATER) || PlantBlockRegistry.isWaterPlant(type))
            return Optional.of(BlockType.WATER);

        if (PlantBlockRegistry.isPlant(type))
            return Optional.of(type);

        return Optional.empty();
    }
}
