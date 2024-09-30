package net.world.map.generator.renderer;

import net.world.map.generator.config.RenderConfig;
import net.world.map.generator.util.ArrayGraphics;
import net.world.map.structure.config.ChunkConfig;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.World;

public class ChunkRenderer {
    public static int[] render(World world, Chunk chunk) {
        int blockWidth = RenderConfig.RENDER_SCALE;
        int blockHeight = RenderConfig.RENDER_SCALE;
        int imageWidth = ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;
        int imageHeight = ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;
        int[] pixels = new int[imageWidth * imageHeight];

        for (int x = 0; x < ChunkConfig.CHUNK_SIZE; x++) {
            for (int y = 0; y < ChunkConfig.CHUNK_SIZE; y++) {
                Block block = chunk.getBlockByLocal(x, y);

                ArrayGraphics.fillRect(x * blockWidth, y * blockHeight, blockWidth, blockHeight,
                        pixels, BlockRenderer.render(world, block), imageWidth);
            }
        }

        return pixels;
    }
}
