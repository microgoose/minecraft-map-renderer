package net.world.map.structure.collecions;

import java.util.HashSet;
import java.util.Set;

public class SolidBlockCollection {
    public static final Set<String> NOT_SOLID_BLOCKS = new HashSet<>();

    static {
        NOT_SOLID_BLOCKS.add(MaterialCollection.AIR);
        NOT_SOLID_BLOCKS.add(MaterialCollection.WATER);
        NOT_SOLID_BLOCKS.add(MaterialCollection.LAVA);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POWERED_RAIL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DETECTOR_RAIL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BROWN_MUSHROOM);
        NOT_SOLID_BLOCKS.add(MaterialCollection.RED_MUSHROOM);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TORCH);
        NOT_SOLID_BLOCKS.add(MaterialCollection.REDSTONE_WIRE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.LADDER);
        NOT_SOLID_BLOCKS.add(MaterialCollection.LEVER);
        NOT_SOLID_BLOCKS.add(MaterialCollection.STONE_BUTTON);
        NOT_SOLID_BLOCKS.add(MaterialCollection.PUMPKIN_STEM);
        NOT_SOLID_BLOCKS.add(MaterialCollection.MELON_STEM);
        NOT_SOLID_BLOCKS.add(MaterialCollection.VINE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.COCOA);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TRIPWIRE_HOOK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TRIPWIRE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FLOWER_POT);
        NOT_SOLID_BLOCKS.add(MaterialCollection.ACTIVATOR_RAIL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.END_ROD);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CHORUS_PLANT);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CHORUS_FLOWER);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SUGAR_CANE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.MELON);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SHORT_GRASS);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TALL_GRASS);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FERN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.LARGE_FERN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.KELP);
        NOT_SOLID_BLOCKS.add(MaterialCollection.WHEAT);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SEA_PICKLE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SEAGRASS);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TALL_SEAGRASS);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SCULK_CATALYST);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FROGSPAWN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.ACACIA_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CHERRY_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.JUNGLE_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DARK_OAK_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CRIMSON_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.WARPED_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.MANGROVE_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BAMBOO_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.OAK_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SPRUCE_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BIRCH_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.ACACIA_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CHERRY_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.JUNGLE_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DARK_OAK_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.MANGROVE_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CRIMSON_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.WARPED_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BAMBOO_WALL_HANGING_SIGN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BUSH);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_TUBE_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BRAIN_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BUBBLE_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_FIRE_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_HORN_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TUBE_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BRAIN_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BUBBLE_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FIRE_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.HORN_CORAL_BLOCK);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_TUBE_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BRAIN_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BUBBLE_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_FIRE_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_HORN_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TUBE_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BRAIN_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BUBBLE_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FIRE_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.HORN_CORAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_TUBE_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BRAIN_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BUBBLE_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_FIRE_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_HORN_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TUBE_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BRAIN_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BUBBLE_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FIRE_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.HORN_CORAL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_TUBE_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BRAIN_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_BUBBLE_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_FIRE_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DEAD_HORN_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.TUBE_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BRAIN_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BUBBLE_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FIRE_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.HORN_CORAL_WALL_FAN);
        NOT_SOLID_BLOCKS.add(MaterialCollection.COBWEB);
        NOT_SOLID_BLOCKS.add(MaterialCollection.FIRE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.STRUCTURE_VOID);
        NOT_SOLID_BLOCKS.add(MaterialCollection.NETHER_PORTAL);
        NOT_SOLID_BLOCKS.add(MaterialCollection.END_GATEWAY);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SNOW);
        NOT_SOLID_BLOCKS.add(MaterialCollection.LIGHT_WEIGHTED_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.HEAVY_WEIGHTED_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POLISHED_BLACKSTONE_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.OAK_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SPRUCE_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BIRCH_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.JUNGLE_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.ACACIA_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CHERRY_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DARK_OAK_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.MANGROVE_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BAMBOO_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.STONE_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CRIMSON_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.WARPED_PRESSURE_PLATE);
        NOT_SOLID_BLOCKS.add(MaterialCollection.SPRUCE_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.OAK_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BIRCH_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.JUNGLE_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.ACACIA_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CHERRY_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.DARK_OAK_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POTTED_OAK_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POTTED_SPRUCE_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POTTED_BIRCH_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POTTED_JUNGLE_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POTTED_ACACIA_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POTTED_CHERRY_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.POTTED_DARK_OAK_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.BAMBOO_SAPLING);
        NOT_SOLID_BLOCKS.add(MaterialCollection.CRIMSON_FUNGUS);
    }

    public static boolean isNotSolid(String blockType) {
        return NOT_SOLID_BLOCKS.contains(blockType);
    }
}