package net.minecountry.renderer;

import net.minecountry.renderer.config.RenderConfig;
import net.minecountry.renderer.utils.ArrayGraphics;
import net.minecountry.world.api.config.ChunkConfig;
import net.minecountry.world.api.locators.BlockLocator;
import net.minecountry.world.api.model.Block;
import net.minecountry.world.api.model.Chunk;
import net.minecountry.world.api.model.World;

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
