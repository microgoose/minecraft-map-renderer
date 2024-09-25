package net.world.map.generator.renderers;

import net.world.map.generator.config.RenderConfig;
import net.world.map.generator.util.ArrayGraphics;
import net.world.map.structure.config.ChunkConfig;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.World;

import java.awt.image.BufferedImage;

public class ChunkRenderer {
    public static BufferedImage render(World world, Chunk chunk) {
        int blockWidth = RenderConfig.RENDER_SCALE;
        int blockHeight = RenderConfig.RENDER_SCALE;
        int imageWidth = ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;
        int imageHeight = ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;
        int[] pixels = new int[imageWidth * imageHeight];

        for (int x = 0; x < ChunkConfig.CHUNK_SIZE; x++) {
            Block chunkBlockX = chunk.getBlockByLocal(x, 0);
            Block aboveChunkBlockX = world.getBlockAt(chunkBlockX.getX(), chunkBlockX.getY() - 1);

            if (aboveChunkBlockX == null) {
                aboveChunkBlockX = chunkBlockX;
            }

            double prevHeight = aboveChunkBlockX.getHeight();

            for (int y = 0; y < ChunkConfig.CHUNK_SIZE; y++) {
                Block block = chunk.getBlockByLocal(x, y);
                BlockRenderer renderer = new BlockRenderer(x, y, prevHeight, block);

                ArrayGraphics.fillRect(x * blockWidth, y * blockHeight, blockWidth, blockHeight,
                        pixels, renderer.render(), imageWidth);

                prevHeight = block.height;
            }
        }

        BufferedImage chunkImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        chunkImage.setRGB(0, 0, imageWidth, imageHeight, pixels, 0, imageWidth);

        return chunkImage;
    }
}
