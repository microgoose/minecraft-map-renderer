package net.world.map.generator.renderers;

import net.world.map.structure.config.BlockMaterials;
import net.world.map.structure.config.ChunkConfig;
import net.world.map.structure.config.ColorsConfig;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.UnderwaterBlock;
import net.world.map.structure.model.World;
import net.world.map.structure.util.Colors;

import java.awt.image.BufferedImage;

public class ChunkRenderer {
    public static BufferedImage render(World world, Chunk chunk) {
        BufferedImage chunkImage =
                new BufferedImage(ChunkConfig.CHUNK_SIZE, ChunkConfig.CHUNK_SIZE, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < ChunkConfig.CHUNK_SIZE; x++) {
            Block chunkBlockX = chunk.getBlockByLocal(x, 0);
            Block aboveChunkBlockX = world.getBlockAt(chunkBlockX.getX(), chunkBlockX.getY() - 1);

            if (aboveChunkBlockX == null) {
                aboveChunkBlockX = chunkBlockX;
            }

            double lastBlockHeight = aboveChunkBlockX.getHeight();

            for (int y = 0; y < ChunkConfig.CHUNK_SIZE; y++) {
                Block block = chunk.getBlockByLocal(x, y);

                int blockHeight = block.getHeight();
                int brightness;
                int color;

                if (block instanceof UnderwaterBlock underwaterBlock) {
                    color = ColorsConfig.getColor(BlockMaterials.WATER);
                    int depth = underwaterBlock.getDepth();
                    double heightDiff = (double) (depth - blockHeight) * 0.1D + (double) (x + y & 1) * 0.2D;

                    if (heightDiff < 0.5D) {
                        brightness = 0x00;
                    } else if (heightDiff > 0.9D) {
                        brightness = 0x44;
                    } else {
                        brightness = 0x22;
                    }
                } else {
                    color = block.getRgb();
                    double heightDiff = (blockHeight - lastBlockHeight) * 4.0D / (double) (1 + 4) + ((double) (x + y & 1) - 0.5D) * 0.4D;

                    if (heightDiff > 0.6D) {
                        brightness = 0;
                    } else if (heightDiff < -0.6D) {
                        brightness = 68;
                    } else {
                        brightness = 34;
                    }
                }

                chunkImage.setRGB(x, y, Colors.blend(brightness << 24, Colors.setAlpha(255, color)));
                lastBlockHeight = block.height;
            }
        }

        return chunkImage;
    }
}
