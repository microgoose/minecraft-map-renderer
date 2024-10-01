package net.minecraft.world2d;

import net.minecraft.world.api.structure.config.ChunkConfig;
import net.minecraft.world.api.structure.model.Block;
import net.minecraft.world.api.structure.model.Chunk;
import net.minecraft.world.api.structure.model.World;
import net.minecraft.world2d.config.RenderConfig;
import net.minecraft.world2d.utils.ArrayGraphics;

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
