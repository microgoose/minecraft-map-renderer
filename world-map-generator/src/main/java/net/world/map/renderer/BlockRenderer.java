package net.world.map.renderer;

import net.world.map.renderer.config.RenderConfig;
import net.world.map.renderer.utils.ArrayGraphics;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.BlockWithMetadata;
import net.world.map.structure.model.World;
import net.world.map.structure.model.metadata.BlockMeta;
import net.world.map.structure.model.metadata.PlantMeta;
import net.world.map.structure.model.metadata.UnderwaterMeta;
import net.world.map.structure.registries.BlockTypes;
import net.world.map.structure.registries.MaterialColorRegistry;
import net.world.map.structure.registries.PlantBlockRegistry;
import net.world.map.renderer.utils.IntegerColors;

import java.util.Map;

public class BlockRenderer {
    public static int[] render(World world, Block block) {
        int blockWidth = RenderConfig.RENDER_SCALE;
        int blockHeight = RenderConfig.RENDER_SCALE;
        int[] pixels = new int[blockWidth * blockHeight];
        int baseColor = MaterialColorRegistry.getColor(block.getBlockType());

        ArrayGraphics.fillRect(0, 0, blockWidth, blockHeight, pixels, baseColor, blockWidth);

        if (block instanceof BlockWithMetadata bwm) {
            drawByMetaData(world, bwm, pixels, baseColor);
        } else {
            drawShading(world, block, pixels, baseColor);
        }

        return pixels;
    }

    private static void drawByMetaData(World world, BlockWithMetadata block, int[] pixels, int baseColor) {
        Map<Class<? extends BlockMeta>, BlockMeta> metadata = block.getMetadata();

        if (metadata.containsKey(PlantMeta.class)) {
            PlantMeta plantMeta = (PlantMeta) metadata.get(PlantMeta.class);
            BlockTypes plantType = plantMeta.getPlantType();

            if (!PlantBlockRegistry.isGrassPlant(plantType)) {
                int plantColor = MaterialColorRegistry.getColor(plantMeta.getPlantType());
                int centerPos = Math.floorDiv(RenderConfig.RENDER_SCALE, 2);
                pixels[centerPos * RenderConfig.RENDER_SCALE + centerPos] = plantColor;
            }
        }

        if (metadata.containsKey(UnderwaterMeta.class)) {
            int brightness;

            UnderwaterMeta meta = (UnderwaterMeta) metadata.get(UnderwaterMeta.class);
            short depth = meta.getDepth();
            double heightDiff = (double) depth * 0.1D + (double) (block.getX() + block.getY() & 1) * 0.2D;
            baseColor = MaterialColorRegistry.getColor(BlockTypes.WATER);

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

        drawShading(world, block, pixels, baseColor);
    }

    private static void drawShading(World world, Block block, int[] pixels, int color) {
        Block leftBlock = world.getBlockAt(block.getX() - 1, block.getY());
        Block topBlock = world.getBlockAt(block.getX(), block.getY() - 1);

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
