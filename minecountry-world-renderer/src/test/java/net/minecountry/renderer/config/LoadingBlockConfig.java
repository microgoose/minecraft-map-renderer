package net.minecountry.renderer.config;

import net.minecountry.world.api.registries.BlockType;

import java.util.EnumSet;

public class LoadingBlockConfig {
    public static final EnumSet<BlockType> IGNORED_BLOCKS = EnumSet.of(
        BlockType.AIR,
        BlockType.CAVE_AIR,

        BlockType.LADDER,

        BlockType.WHITE_BANNER,
        BlockType.ORANGE_BANNER,
        BlockType.MAGENTA_BANNER,
        BlockType.LIGHT_BLUE_BANNER,
        BlockType.YELLOW_BANNER,
        BlockType.LIME_BANNER,
        BlockType.PINK_BANNER,
        BlockType.GRAY_BANNER,
        BlockType.LIGHT_GRAY_BANNER,
        BlockType.CYAN_BANNER,
        BlockType.PURPLE_BANNER,
        BlockType.BLUE_BANNER,
        BlockType.BROWN_BANNER,
        BlockType.GREEN_BANNER,
        BlockType.RED_BANNER,
        BlockType.BLACK_BANNER,
        BlockType.WHITE_WALL_BANNER,
        BlockType.ORANGE_WALL_BANNER,
        BlockType.MAGENTA_WALL_BANNER,
        BlockType.LIGHT_BLUE_WALL_BANNER,
        BlockType.YELLOW_WALL_BANNER,
        BlockType.LIME_WALL_BANNER,
        BlockType.PINK_WALL_BANNER,
        BlockType.GRAY_WALL_BANNER,
        BlockType.LIGHT_GRAY_WALL_BANNER,
        BlockType.CYAN_WALL_BANNER,
        BlockType.PURPLE_WALL_BANNER,
        BlockType.BLUE_WALL_BANNER,
        BlockType.BROWN_WALL_BANNER,
        BlockType.GREEN_WALL_BANNER,
        BlockType.RED_WALL_BANNER,
        BlockType.BLACK_WALL_BANNER,

        BlockType.FROGSPAWN,

        BlockType.OAK_HANGING_SIGN,
        BlockType.SPRUCE_HANGING_SIGN,
        BlockType.BIRCH_HANGING_SIGN,
        BlockType.ACACIA_HANGING_SIGN,
        BlockType.CHERRY_HANGING_SIGN,
        BlockType.JUNGLE_HANGING_SIGN,
        BlockType.DARK_OAK_HANGING_SIGN,
        BlockType.CRIMSON_HANGING_SIGN,
        BlockType.WARPED_HANGING_SIGN,
        BlockType.MANGROVE_HANGING_SIGN,
        BlockType.BAMBOO_HANGING_SIGN,
        BlockType.OAK_WALL_HANGING_SIGN,
        BlockType.SPRUCE_WALL_HANGING_SIGN,
        BlockType.BIRCH_WALL_HANGING_SIGN,
        BlockType.ACACIA_WALL_HANGING_SIGN,
        BlockType.CHERRY_WALL_HANGING_SIGN,
        BlockType.JUNGLE_WALL_HANGING_SIGN,
        BlockType.DARK_OAK_WALL_HANGING_SIGN,
        BlockType.MANGROVE_WALL_HANGING_SIGN,
        BlockType.CRIMSON_WALL_HANGING_SIGN,
        BlockType.WARPED_WALL_HANGING_SIGN,
        BlockType.BAMBOO_WALL_HANGING_SIGN
    );
}
