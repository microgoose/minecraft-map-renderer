package net.minecountry.renderer.common;

import net.minecountry.renderer.config.LoadingBlockConfig;
import net.minecountry.world.api.registries.BlockType;
import net.minecountry.world.io.mca.common.BlockFilter;

public class RenderBlockFilter implements BlockFilter {
    @Override
    public boolean shouldIgnore(BlockType type) {
        return LoadingBlockConfig.IGNORED_BLOCKS.contains(type);
    }
}
