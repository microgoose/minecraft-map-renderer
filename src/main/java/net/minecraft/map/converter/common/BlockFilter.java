package net.minecraft.map.converter.common;

import net.minecraft.map.core.registries.BlockType;

public interface BlockFilter {
    boolean shouldIgnore(BlockType type);
}
