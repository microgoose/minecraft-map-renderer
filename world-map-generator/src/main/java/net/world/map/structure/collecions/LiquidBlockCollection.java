package net.world.map.structure.collecions;

import java.util.HashSet;
import java.util.Set;

public class LiquidBlockCollection {
    public static final Set<String> LIQUID_BLOCKS = new HashSet<>();

    static {
        LIQUID_BLOCKS.add(MaterialCollection.WATER);
        LIQUID_BLOCKS.add(MaterialCollection.LAVA);
    }

    public static boolean isLiquid(String blockType) {
        return LIQUID_BLOCKS.contains(blockType);
    }
}