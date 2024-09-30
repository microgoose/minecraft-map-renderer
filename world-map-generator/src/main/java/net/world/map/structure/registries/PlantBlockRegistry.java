package net.world.map.structure.registries;

import java.util.EnumSet;

public class PlantBlockRegistry {
    public static final EnumSet<BlockTypes> ALL_PLANT_BLOCKS = EnumSet.of(
            BlockTypes.FERN,
            BlockTypes.LARGE_FERN,
            BlockTypes.DEAD_BUSH,
            BlockTypes.DANDELION,
            BlockTypes.POPPY,
            BlockTypes.BLUE_ORCHID,
            BlockTypes.ALLIUM,
            BlockTypes.AZURE_BLUET,
            BlockTypes.RED_TULIP,
            BlockTypes.ORANGE_TULIP,
            BlockTypes.WHITE_TULIP,
            BlockTypes.PINK_TULIP,
            BlockTypes.OXEYE_DAISY,
            BlockTypes.CORNFLOWER,
            BlockTypes.LILY_OF_THE_VALLEY,
            BlockTypes.WITHER_ROSE,
            BlockTypes.SUNFLOWER,
            BlockTypes.LILAC,
            BlockTypes.ROSE_BUSH,
            BlockTypes.PEONY,
            BlockTypes.OAK_SAPLING,
            BlockTypes.SPRUCE_SAPLING,
            BlockTypes.BIRCH_SAPLING,
            BlockTypes.JUNGLE_SAPLING,
            BlockTypes.ACACIA_SAPLING,
            BlockTypes.DARK_OAK_SAPLING,
            BlockTypes.MANGROVE_PROPAGULE,
            BlockTypes.SWEET_BERRY_BUSH,
            BlockTypes.CAVE_VINES,
            BlockTypes.VINE,
            BlockTypes.TWISTING_VINES,
            BlockTypes.WEEPING_VINES,
            BlockTypes.SUGAR_CANE,
            BlockTypes.CACTUS,
            BlockTypes.BAMBOO,
            BlockTypes.RED_MUSHROOM,
            BlockTypes.BROWN_MUSHROOM,
            BlockTypes.MUSHROOM_STEM,
            BlockTypes.MOSS_BLOCK,
            BlockTypes.MOSS_CARPET,
            BlockTypes.AZALEA,
            BlockTypes.FLOWERING_AZALEA,
            BlockTypes.WARPED_FUNGUS,
            BlockTypes.CRIMSON_FUNGUS,
            BlockTypes.WARPED_ROOTS,
            BlockTypes.CRIMSON_ROOTS,
            BlockTypes.NETHER_SPROUTS,
            BlockTypes.BRAIN_CORAL,
            BlockTypes.BUBBLE_CORAL,
            BlockTypes.FIRE_CORAL,
            BlockTypes.HORN_CORAL,
            BlockTypes.TUBE_CORAL
    );

    public static final EnumSet<BlockTypes> WATER_PLANT_BLOCKS = EnumSet.of(
            BlockTypes.SEAGRASS,
            BlockTypes.TALL_SEAGRASS,
            BlockTypes.KELP,
            BlockTypes.KELP_PLANT,
            BlockTypes.LILY_PAD,
            BlockTypes.CHORUS_PLANT,
            BlockTypes.CHORUS_FLOWER,
            BlockTypes.BRAIN_CORAL,
            BlockTypes.BUBBLE_CORAL,
            BlockTypes.FIRE_CORAL,
            BlockTypes.HORN_CORAL,
            BlockTypes.TUBE_CORAL,
            BlockTypes.DEAD_BRAIN_CORAL,
            BlockTypes.DEAD_BUBBLE_CORAL,
            BlockTypes.DEAD_FIRE_CORAL,
            BlockTypes.DEAD_HORN_CORAL,
            BlockTypes.DEAD_TUBE_CORAL
    );

    public static final EnumSet<BlockTypes> GRASS_PLANT_BLOCKS = EnumSet.of(
            BlockTypes.SHORT_GRASS,
            BlockTypes.TALL_GRASS
    );

    public static boolean isPlant(BlockTypes type) {
        return ALL_PLANT_BLOCKS.contains(type) ||
                WATER_PLANT_BLOCKS.contains(type) ||
                GRASS_PLANT_BLOCKS.contains(type);
    }

    public static boolean isWaterPlant(BlockTypes type) {
        return WATER_PLANT_BLOCKS.contains(type);
    }

    public static boolean isGrassPlant(BlockTypes type) {
        return GRASS_PLANT_BLOCKS.contains(type);
    }
}
