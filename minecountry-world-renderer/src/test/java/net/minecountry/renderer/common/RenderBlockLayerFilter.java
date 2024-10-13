package net.minecountry.renderer.common;

import net.minecountry.world.api.registries.BlockType;
import net.minecountry.world.api.registries.PlantBlockRegistry;
import net.minecountry.world.io.mca.common.BlockLayerFilter;

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
