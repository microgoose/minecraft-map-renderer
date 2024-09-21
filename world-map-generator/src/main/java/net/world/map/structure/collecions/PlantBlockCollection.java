package net.world.map.structure.collecions;

import java.util.HashSet;
import java.util.Set;

public class PlantBlockCollection {
    public static final Set<String> PLANT_BLOCKS = new HashSet<>();

    static {
        PLANT_BLOCKS.add(MaterialCollection.SHORT_GRASS);
        PLANT_BLOCKS.add(MaterialCollection.TALL_GRASS);
        PLANT_BLOCKS.add(MaterialCollection.FERN);
        PLANT_BLOCKS.add(MaterialCollection.LARGE_FERN);
        PLANT_BLOCKS.add(MaterialCollection.DEAD_BUSH);
        PLANT_BLOCKS.add(MaterialCollection.DANDELION);
        PLANT_BLOCKS.add(MaterialCollection.POPPY);
        PLANT_BLOCKS.add(MaterialCollection.BLUE_ORCHID);
        PLANT_BLOCKS.add(MaterialCollection.ALLIUM);
        PLANT_BLOCKS.add(MaterialCollection.AZURE_BLUET);
        PLANT_BLOCKS.add(MaterialCollection.RED_TULIP);
        PLANT_BLOCKS.add(MaterialCollection.ORANGE_TULIP);
        PLANT_BLOCKS.add(MaterialCollection.WHITE_TULIP);
        PLANT_BLOCKS.add(MaterialCollection.PINK_TULIP);
        PLANT_BLOCKS.add(MaterialCollection.OXEYE_DAISY);
        PLANT_BLOCKS.add(MaterialCollection.CORNFLOWER);
        PLANT_BLOCKS.add(MaterialCollection.LILY_OF_THE_VALLEY);
        PLANT_BLOCKS.add(MaterialCollection.WITHER_ROSE);
        PLANT_BLOCKS.add(MaterialCollection.SUNFLOWER);
        PLANT_BLOCKS.add(MaterialCollection.LILAC);
        PLANT_BLOCKS.add(MaterialCollection.ROSE_BUSH);
        PLANT_BLOCKS.add(MaterialCollection.PEONY);
        PLANT_BLOCKS.add(MaterialCollection.OAK_SAPLING);
        PLANT_BLOCKS.add(MaterialCollection.SPRUCE_SAPLING);
        PLANT_BLOCKS.add(MaterialCollection.BIRCH_SAPLING);
        PLANT_BLOCKS.add(MaterialCollection.JUNGLE_SAPLING);
        PLANT_BLOCKS.add(MaterialCollection.ACACIA_SAPLING);
        PLANT_BLOCKS.add(MaterialCollection.DARK_OAK_SAPLING);
        PLANT_BLOCKS.add(MaterialCollection.MANGROVE_PROPAGULE);
        PLANT_BLOCKS.add(MaterialCollection.SEAGRASS);
        PLANT_BLOCKS.add(MaterialCollection.TALL_SEAGRASS);
        PLANT_BLOCKS.add(MaterialCollection.KELP);
        PLANT_BLOCKS.add(MaterialCollection.KELP_PLANT);
        PLANT_BLOCKS.add(MaterialCollection.LILY_PAD);
        PLANT_BLOCKS.add(MaterialCollection.SWEET_BERRY_BUSH);
        PLANT_BLOCKS.add(MaterialCollection.CAVE_VINES);
        PLANT_BLOCKS.add(MaterialCollection.VINE);
        PLANT_BLOCKS.add(MaterialCollection.TWISTING_VINES);
        PLANT_BLOCKS.add(MaterialCollection.WEEPING_VINES);
        PLANT_BLOCKS.add(MaterialCollection.SUGAR_CANE);
        PLANT_BLOCKS.add(MaterialCollection.CACTUS);
        PLANT_BLOCKS.add(MaterialCollection.BAMBOO);
        PLANT_BLOCKS.add(MaterialCollection.CHORUS_PLANT);
        PLANT_BLOCKS.add(MaterialCollection.CHORUS_FLOWER);
        PLANT_BLOCKS.add(MaterialCollection.RED_MUSHROOM);
        PLANT_BLOCKS.add(MaterialCollection.BROWN_MUSHROOM);
        PLANT_BLOCKS.add(MaterialCollection.MUSHROOM_STEM);
        PLANT_BLOCKS.add(MaterialCollection.MOSS_BLOCK);
        PLANT_BLOCKS.add(MaterialCollection.MOSS_CARPET);
        PLANT_BLOCKS.add(MaterialCollection.AZALEA);
        PLANT_BLOCKS.add(MaterialCollection.FLOWERING_AZALEA);
        PLANT_BLOCKS.add(MaterialCollection.WARPED_FUNGUS);
        PLANT_BLOCKS.add(MaterialCollection.CRIMSON_FUNGUS);
        PLANT_BLOCKS.add(MaterialCollection.WARPED_ROOTS);
        PLANT_BLOCKS.add(MaterialCollection.CRIMSON_ROOTS);
        PLANT_BLOCKS.add(MaterialCollection.NETHER_SPROUTS);
        PLANT_BLOCKS.add(MaterialCollection.BRAIN_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.BUBBLE_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.FIRE_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.HORN_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.TUBE_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.DEAD_BRAIN_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.DEAD_BUBBLE_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.DEAD_FIRE_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.DEAD_HORN_CORAL);
        PLANT_BLOCKS.add(MaterialCollection.DEAD_TUBE_CORAL);
    }

    public static boolean isPlant(String blockType) {
        return PLANT_BLOCKS.contains(blockType);
    }
}
