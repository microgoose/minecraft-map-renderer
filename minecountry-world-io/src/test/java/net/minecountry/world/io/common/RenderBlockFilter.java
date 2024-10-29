package net.minecountry.world.io.common;

import net.minecountry.world.api.registries.BlockType;
import net.minecountry.world.io.config.LoadingBlockConfig;
import net.minecountry.world.io.mca.common.BlockFilter;

public class RenderBlockFilter implements BlockFilter {
    @Override
    public boolean shouldIgnore(BlockType type) {
        return LoadingBlockConfig.IGNORED_BLOCKS.contains(type);
    }
}
