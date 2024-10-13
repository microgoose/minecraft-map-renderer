package net.minecountry.renderer;

import net.minecountry.renderer.config.RenderConfig;
import net.minecountry.renderer.utils.ArrayGraphics;
import net.minecountry.renderer.utils.IntegerColors;
import net.minecountry.world.api.model.Block;
import net.minecountry.world.api.model.LayeredBlock;
import net.minecountry.world.api.model.World;
import net.minecountry.world.api.registries.BlockType;
import net.minecountry.world.api.registries.BlockTypeColorRegistry;
import net.minecountry.world.api.registries.PlantBlockRegistry;
import net.minecountry.world.api.locators.BlockLocator;

public class BlockRenderer {
    public static int[] render(World world, Block block) {
        int blockWidth = RenderConfig.RENDER_SCALE;
        int blockHeight = RenderConfig.RENDER_SCALE;
        int[] pixels = new int[blockWidth * blockHeight];
        int baseColor = BlockTypeColorRegistry.getColor(block.getBlockType());

        ArrayGraphics.fillRect(0, 0, blockWidth, blockHeight, pixels, baseColor, blockWidth);

        if (block instanceof LayeredBlock lb) {
            drawByMetaData(world, lb, pixels, baseColor);
        } else {
            drawShading(world, block, pixels, baseColor);
        }

        return pixels;
    }

    private static void drawByMetaData(World world, LayeredBlock layeredBlock, int[] pixels, int baseColor) {
        short[] types = layeredBlock.getTypes();
        short[] heights = layeredBlock.getHeights();

        for (int j = 0; j < types.length; j++) {
            short type = types[j];
            short height = heights[j];
            BlockType blockType = BlockType.getById(type);

            if (blockType == BlockType.WATER) {
                short depth = (short) (height - layeredBlock.getHeight());
                double heightDiff = (double) depth * 0.1D + (double) (layeredBlock.getX() + layeredBlock.getY() & 1) * 0.2D;
                baseColor = BlockTypeColorRegistry.getColor(BlockType.WATER);

                int brightness;
                if (heightDiff < 0.5D) {
                    brightness = 0x00;
                } else if (heightDiff > 0.9D) {
                    brightness = 0x44;
                } else {
                    brightness = 0x22;
                }

                baseColor = IntegerColors.blend(brightness << 24, baseColor);
                ArrayGraphics.fillRect(0, 0, RenderConfig.RENDER_SCALE, RenderConfig.RENDER_SCALE,
                        pixels, baseColor, RenderConfig.RENDER_SCALE);

                return;
            }

            if (PlantBlockRegistry.isPlant(blockType)) {
                if (!PlantBlockRegistry.isGrassPlant(blockType)) {
                    int plantColor = BlockTypeColorRegistry.getColor(blockType);
                    int centerPos = Math.floorDiv(RenderConfig.RENDER_SCALE, 2);
                    pixels[centerPos * RenderConfig.RENDER_SCALE + centerPos] = plantColor;
                }
            }
        }

        drawShading(world, layeredBlock, pixels, baseColor);
    }

    private static void drawShading(World world, Block block, int[] pixels, int color) {
        Block leftBlock = BlockLocator.getAtGlobal(world, block.getX() - 1, block.getY());
        Block topBlock = BlockLocator.getAtGlobal(world, block.getX(), block.getY() - 1);

        if (leftBlock != null) {
            int heightDiff = block.getHeight() - leftBlock.getHeight();

            if (heightDiff > 0)
                drawLeftVerticalLine(pixels, IntegerColors.adjustBrightness(color, 20));
            else if (heightDiff < 0)
                drawLeftVerticalLine(pixels, IntegerColors.adjustBrightness(color, -20));
        }

        if (topBlock != null) {
            int heightDiff = block.getHeight() - topBlock.getHeight();

            if (heightDiff > 0)
                drawTopHorizontalLine(pixels, IntegerColors.adjustBrightness(color, 20));
            else if (heightDiff < 0)
                drawTopHorizontalLine(pixels, IntegerColors.adjustBrightness(color, -20));
        }
    }

    private static void drawTopHorizontalLine(int[] pixels, int color) {
        for (int x = 0; x < RenderConfig.RENDER_SCALE; x++) {
            pixels[x] = color;
        }
    }

    private static void drawLeftVerticalLine(int[] pixels, int color) {
        for (int x = 0; x < pixels.length; x += RenderConfig.RENDER_SCALE) {
            pixels[x] = color;
        }
    }
}
