package net.minecraft.map.renderer.common;

import net.minecraft.map.converter.common.BlockFilter;
import net.minecraft.map.core.registries.BlockType;
import net.minecraft.map.renderer.config.LoadingBlockConfig;

public class RenderBlockFilter implements BlockFilter {
    @Override
    public boolean shouldIgnore(BlockType type) {
        return LoadingBlockConfig.IGNORED_BLOCKS.contains(type);
    }
}
