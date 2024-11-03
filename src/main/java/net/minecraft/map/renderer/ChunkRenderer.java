package net.minecraft.map.renderer;

import net.minecraft.map.core.config.ChunkConfig;
import net.minecraft.map.core.locators.BlockLocator;
import net.minecraft.map.core.model.Block;
import net.minecraft.map.core.model.Chunk;
import net.minecraft.map.core.model.World;
import net.minecraft.map.renderer.config.RenderConfig;
import net.minecraft.map.renderer.utils.ArrayGraphics;

public class ChunkRenderer {
    public static int[] render(World world, Chunk chunk) {
        int blockWidth = RenderConfig.RENDER_SCALE;
        int blockHeight = RenderConfig.RENDER_SCALE;
        int imageWidth = ChunkConfig.BLOCKS_SIDE * RenderConfig.RENDER_SCALE;
        int imageHeight = ChunkConfig.BLOCKS_SIDE * RenderConfig.RENDER_SCALE;
        int[] pixels = new int[imageWidth * imageHeight];

        for (int x = 0; x < ChunkConfig.BLOCKS_SIDE; x++) {
            for (int y = 0; y < ChunkConfig.BLOCKS_SIDE; y++) {
                Block block = BlockLocator.getAtLocal(chunk, x, y);

                ArrayGraphics.fillRect(x * blockWidth, y * blockHeight, blockWidth, blockHeight,
                        pixels, BlockRenderer.render(world, block), imageWidth);
            }
        }

        return pixels;
    }
}
