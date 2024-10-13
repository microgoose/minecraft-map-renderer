package net.minecountry.world.io.mca.common;

import net.minecountry.world.api.registries.BlockType;

public interface BlockFilter {
    boolean shouldIgnore(BlockType type);
}
