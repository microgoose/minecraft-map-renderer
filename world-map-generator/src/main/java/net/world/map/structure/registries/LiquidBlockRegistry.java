package net.world.map.structure.registries;

import java.util.EnumSet;

public class LiquidBlockRegistry {
    public static final EnumSet<BlockTypes> LIQUID_BLOCKS = EnumSet.of(
        BlockTypes.WATER,
        BlockTypes.LAVA
    );

    public static boolean isLiquid(BlockTypes type) {
        return LIQUID_BLOCKS.contains(type);
    }
}