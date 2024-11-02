package net.minecountry.world.api.registries;

import java.util.EnumSet;

public class PlantBlockRegistry {
    public static final EnumSet<BlockType> ALL_PLANT_BLOCKS = EnumSet.of(
            BlockType.FERN,
            BlockType.LARGE_FERN,
            BlockType.DEAD_BUSH,
            BlockType.DANDELION,
            BlockType.POPPY,
            BlockType.BLUE_ORCHID,
            BlockType.ALLIUM,
            BlockType.AZURE_BLUET,
            BlockType.RED_TULIP,
            BlockType.ORANGE_TULIP,
            BlockType.WHITE_TULIP,
            BlockType.PINK_TULIP,
            BlockType.OXEYE_DAISY,
            BlockType.CORNFLOWER,
            BlockType.LILY_OF_THE_VALLEY,
            BlockType.WITHER_ROSE,
            BlockType.SUNFLOWER,
            BlockType.LILAC,
            BlockType.ROSE_BUSH,
            BlockType.PEONY,
            BlockType.OAK_SAPLING,
            BlockType.SPRUCE_SAPLING,
            BlockType.BIRCH_SAPLING,
            BlockType.JUNGLE_SAPLING,
            BlockType.ACACIA_SAPLING,
            BlockType.DARK_OAK_SAPLING,
            BlockType.MANGROVE_PROPAGULE,
            BlockType.SWEET_BERRY_BUSH,
            BlockType.CAVE_VINES,
            BlockType.VINE,
            BlockType.TWISTING_VINES,
            BlockType.WEEPING_VINES,
            BlockType.SUGAR_CANE,
            BlockType.CACTUS,
            BlockType.BAMBOO,
            BlockType.RED_MUSHROOM,
            BlockType.BROWN_MUSHROOM,
            BlockType.MUSHROOM_STEM,
            BlockType.MOSS_BLOCK,
            BlockType.MOSS_CARPET,
            BlockType.AZALEA,
            BlockType.FLOWERING_AZALEA,
            BlockType.WARPED_FUNGUS,
            BlockType.CRIMSON_FUNGUS,
            BlockType.WARPED_ROOTS,
            BlockType.CRIMSON_ROOTS,
            BlockType.NETHER_SPROUTS,
            BlockType.BRAIN_CORAL,
            BlockType.BUBBLE_CORAL,
            BlockType.FIRE_CORAL,
            BlockType.HORN_CORAL,
            BlockType.TUBE_CORAL
    );

    public static final EnumSet<BlockType> WATER_PLANT_BLOCKS = EnumSet.of(
            BlockType.SEAGRASS,
            BlockType.TALL_SEAGRASS,
            BlockType.KELP,
            BlockType.KELP_PLANT,
            BlockType.LILY_PAD,
            BlockType.CHORUS_PLANT,
            BlockType.CHORUS_FLOWER,
            BlockType.BRAIN_CORAL,
            BlockType.BUBBLE_CORAL,
            BlockType.FIRE_CORAL,
            BlockType.HORN_CORAL,
            BlockType.TUBE_CORAL,
            BlockType.DEAD_BRAIN_CORAL,
            BlockType.DEAD_BUBBLE_CORAL,
            BlockType.DEAD_FIRE_CORAL,
            BlockType.DEAD_HORN_CORAL,
            BlockType.DEAD_TUBE_CORAL
    );

    public static final EnumSet<BlockType> GRASS_PLANT_BLOCKS = EnumSet.of(
            BlockType.SHORT_GRASS,
            BlockType.TALL_GRASS
    );

    public static boolean isPlant(BlockType type) {
        return ALL_PLANT_BLOCKS.contains(type) ||
                WATER_PLANT_BLOCKS.contains(type) ||
                GRASS_PLANT_BLOCKS.contains(type);
    }

    public static boolean isWaterPlant(BlockType type) {
        return WATER_PLANT_BLOCKS.contains(type);
    }

    public static boolean isGrassPlant(BlockType type) {
        return GRASS_PLANT_BLOCKS.contains(type);
    }
}
