package net.minecountry.world.api.structure.registries;

import java.util.EnumSet;

public class LiquidBlockRegistry {
    public static final EnumSet<BlockType> LIQUID_BLOCKS = EnumSet.of(
        BlockType.WATER,
        BlockType.LAVA
    );

    public static boolean isLiquid(BlockType type) {
        return LIQUID_BLOCKS.contains(type);
    }
}