package net.world.map.structure.collecions;

import java.util.HashSet;
import java.util.Set;

public class PlantBlockCollection {
    public static final Set<String> ALL_PLANT_BLOCKS = new HashSet<>();
    public static final Set<String> WATER_PLANT_BLOCKS = new HashSet<>();

    static {
        ALL_PLANT_BLOCKS.add(MaterialCollection.SHORT_GRASS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.TALL_GRASS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.FERN);
        ALL_PLANT_BLOCKS.add(MaterialCollection.LARGE_FERN);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DEAD_BUSH);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DANDELION);
        ALL_PLANT_BLOCKS.add(MaterialCollection.POPPY);
        ALL_PLANT_BLOCKS.add(MaterialCollection.BLUE_ORCHID);
        ALL_PLANT_BLOCKS.add(MaterialCollection.ALLIUM);
        ALL_PLANT_BLOCKS.add(MaterialCollection.AZURE_BLUET);
        ALL_PLANT_BLOCKS.add(MaterialCollection.RED_TULIP);
        ALL_PLANT_BLOCKS.add(MaterialCollection.ORANGE_TULIP);
        ALL_PLANT_BLOCKS.add(MaterialCollection.WHITE_TULIP);
        ALL_PLANT_BLOCKS.add(MaterialCollection.PINK_TULIP);
        ALL_PLANT_BLOCKS.add(MaterialCollection.OXEYE_DAISY);
        ALL_PLANT_BLOCKS.add(MaterialCollection.CORNFLOWER);
        ALL_PLANT_BLOCKS.add(MaterialCollection.LILY_OF_THE_VALLEY);
        ALL_PLANT_BLOCKS.add(MaterialCollection.WITHER_ROSE);
        ALL_PLANT_BLOCKS.add(MaterialCollection.SUNFLOWER);
        ALL_PLANT_BLOCKS.add(MaterialCollection.LILAC);
        ALL_PLANT_BLOCKS.add(MaterialCollection.ROSE_BUSH);
        ALL_PLANT_BLOCKS.add(MaterialCollection.PEONY);
        ALL_PLANT_BLOCKS.add(MaterialCollection.OAK_SAPLING);
        ALL_PLANT_BLOCKS.add(MaterialCollection.SPRUCE_SAPLING);
        ALL_PLANT_BLOCKS.add(MaterialCollection.BIRCH_SAPLING);
        ALL_PLANT_BLOCKS.add(MaterialCollection.JUNGLE_SAPLING);
        ALL_PLANT_BLOCKS.add(MaterialCollection.ACACIA_SAPLING);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DARK_OAK_SAPLING);
        ALL_PLANT_BLOCKS.add(MaterialCollection.MANGROVE_PROPAGULE);
        ALL_PLANT_BLOCKS.add(MaterialCollection.SEAGRASS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.TALL_SEAGRASS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.KELP);
        ALL_PLANT_BLOCKS.add(MaterialCollection.KELP_PLANT);
        ALL_PLANT_BLOCKS.add(MaterialCollection.LILY_PAD);
        ALL_PLANT_BLOCKS.add(MaterialCollection.SWEET_BERRY_BUSH);
        ALL_PLANT_BLOCKS.add(MaterialCollection.CAVE_VINES);
        ALL_PLANT_BLOCKS.add(MaterialCollection.VINE);
        ALL_PLANT_BLOCKS.add(MaterialCollection.TWISTING_VINES);
        ALL_PLANT_BLOCKS.add(MaterialCollection.WEEPING_VINES);
        ALL_PLANT_BLOCKS.add(MaterialCollection.SUGAR_CANE);
        ALL_PLANT_BLOCKS.add(MaterialCollection.CACTUS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.BAMBOO);
        ALL_PLANT_BLOCKS.add(MaterialCollection.CHORUS_PLANT);
        ALL_PLANT_BLOCKS.add(MaterialCollection.CHORUS_FLOWER);
        ALL_PLANT_BLOCKS.add(MaterialCollection.RED_MUSHROOM);
        ALL_PLANT_BLOCKS.add(MaterialCollection.BROWN_MUSHROOM);
        ALL_PLANT_BLOCKS.add(MaterialCollection.MUSHROOM_STEM);
        ALL_PLANT_BLOCKS.add(MaterialCollection.MOSS_BLOCK);
        ALL_PLANT_BLOCKS.add(MaterialCollection.MOSS_CARPET);
        ALL_PLANT_BLOCKS.add(MaterialCollection.AZALEA);
        ALL_PLANT_BLOCKS.add(MaterialCollection.FLOWERING_AZALEA);
        ALL_PLANT_BLOCKS.add(MaterialCollection.WARPED_FUNGUS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.CRIMSON_FUNGUS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.WARPED_ROOTS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.CRIMSON_ROOTS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.NETHER_SPROUTS);
        ALL_PLANT_BLOCKS.add(MaterialCollection.BRAIN_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.BUBBLE_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.FIRE_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.HORN_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.TUBE_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DEAD_BRAIN_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DEAD_BUBBLE_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DEAD_FIRE_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DEAD_HORN_CORAL);
        ALL_PLANT_BLOCKS.add(MaterialCollection.DEAD_TUBE_CORAL);

        WATER_PLANT_BLOCKS.add(MaterialCollection.SEAGRASS);
        WATER_PLANT_BLOCKS.add(MaterialCollection.TALL_SEAGRASS);
        WATER_PLANT_BLOCKS.add(MaterialCollection.KELP);
        WATER_PLANT_BLOCKS.add(MaterialCollection.KELP_PLANT);
        WATER_PLANT_BLOCKS.add(MaterialCollection.LILY_PAD);
        WATER_PLANT_BLOCKS.add(MaterialCollection.CHORUS_PLANT);
        WATER_PLANT_BLOCKS.add(MaterialCollection.CHORUS_FLOWER);
        WATER_PLANT_BLOCKS.add(MaterialCollection.BRAIN_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.BUBBLE_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.FIRE_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.HORN_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.TUBE_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.DEAD_BRAIN_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.DEAD_BUBBLE_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.DEAD_FIRE_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.DEAD_HORN_CORAL);
        WATER_PLANT_BLOCKS.add(MaterialCollection.DEAD_TUBE_CORAL);
    }

    public static boolean isPlant(String blockType) {
        return ALL_PLANT_BLOCKS.contains(blockType);
    }

    public static boolean isWaterPlant(String blockType) {
        return WATER_PLANT_BLOCKS.contains(blockType);
    }
}
