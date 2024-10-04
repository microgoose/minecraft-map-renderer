package net.minecraft.world.api.loader.config;

import net.minecraft.world.api.structure.registries.BlockTypes;

import java.util.EnumSet;

public class LoadingBlockConfig {
    public static final EnumSet<BlockTypes> IGNORED_BLOCKS = EnumSet.of(
        BlockTypes.AIR,
        BlockTypes.CAVE_AIR,

        BlockTypes.LADDER,

        BlockTypes.WHITE_BANNER,
        BlockTypes.ORANGE_BANNER,
        BlockTypes.MAGENTA_BANNER,
        BlockTypes.LIGHT_BLUE_BANNER,
        BlockTypes.YELLOW_BANNER,
        BlockTypes.LIME_BANNER,
        BlockTypes.PINK_BANNER,
        BlockTypes.GRAY_BANNER,
        BlockTypes.LIGHT_GRAY_BANNER,
        BlockTypes.CYAN_BANNER,
        BlockTypes.PURPLE_BANNER,
        BlockTypes.BLUE_BANNER,
        BlockTypes.BROWN_BANNER,
        BlockTypes.GREEN_BANNER,
        BlockTypes.RED_BANNER,
        BlockTypes.BLACK_BANNER,
        BlockTypes.WHITE_WALL_BANNER,
        BlockTypes.ORANGE_WALL_BANNER,
        BlockTypes.MAGENTA_WALL_BANNER,
        BlockTypes.LIGHT_BLUE_WALL_BANNER,
        BlockTypes.YELLOW_WALL_BANNER,
        BlockTypes.LIME_WALL_BANNER,
        BlockTypes.PINK_WALL_BANNER,
        BlockTypes.GRAY_WALL_BANNER,
        BlockTypes.LIGHT_GRAY_WALL_BANNER,
        BlockTypes.CYAN_WALL_BANNER,
        BlockTypes.PURPLE_WALL_BANNER,
        BlockTypes.BLUE_WALL_BANNER,
        BlockTypes.BROWN_WALL_BANNER,
        BlockTypes.GREEN_WALL_BANNER,
        BlockTypes.RED_WALL_BANNER,
        BlockTypes.BLACK_WALL_BANNER,

        BlockTypes.FROGSPAWN,

        BlockTypes.OAK_HANGING_SIGN,
        BlockTypes.SPRUCE_HANGING_SIGN,
        BlockTypes.BIRCH_HANGING_SIGN,
        BlockTypes.ACACIA_HANGING_SIGN,
        BlockTypes.CHERRY_HANGING_SIGN,
        BlockTypes.JUNGLE_HANGING_SIGN,
        BlockTypes.DARK_OAK_HANGING_SIGN,
        BlockTypes.CRIMSON_HANGING_SIGN,
        BlockTypes.WARPED_HANGING_SIGN,
        BlockTypes.MANGROVE_HANGING_SIGN,
        BlockTypes.BAMBOO_HANGING_SIGN,
        BlockTypes.OAK_WALL_HANGING_SIGN,
        BlockTypes.SPRUCE_WALL_HANGING_SIGN,
        BlockTypes.BIRCH_WALL_HANGING_SIGN,
        BlockTypes.ACACIA_WALL_HANGING_SIGN,
        BlockTypes.CHERRY_WALL_HANGING_SIGN,
        BlockTypes.JUNGLE_WALL_HANGING_SIGN,
        BlockTypes.DARK_OAK_WALL_HANGING_SIGN,
        BlockTypes.MANGROVE_WALL_HANGING_SIGN,
        BlockTypes.CRIMSON_WALL_HANGING_SIGN,
        BlockTypes.WARPED_WALL_HANGING_SIGN,
        BlockTypes.BAMBOO_WALL_HANGING_SIGN
    );
}
