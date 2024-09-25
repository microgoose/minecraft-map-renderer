package net.world.map.generator.renderers;

import net.world.map.generator.config.RenderConfig;
import net.world.map.structure.collecions.BlockType;
import net.world.map.structure.collecions.MaterialColorCollection;
import net.world.map.structure.collecions.PlantBlockCollection;
import net.world.map.structure.config.ChunkConfig;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.BlockWithMetadata;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.World;
import net.world.map.structure.model.metadata.BlockMeta;
import net.world.map.structure.model.metadata.PlantMeta;
import net.world.map.structure.model.metadata.UnderwaterMeta;
import net.world.map.structure.util.Colors;

import java.awt.image.BufferedImage;
import java.util.Map;

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
                int color = MaterialColorCollection.getColor(block.getBlockType());

                if (block instanceof BlockWithMetadata blockWithMetadata) {
                    color = modifyColorByMetadata(blockWithMetadata, prevHeight, x, y, color);
                } else {
                    color = modifyColorByHeight(x, y, block.getHeight(), prevHeight, color);
                }

                fillRect(x * blockWidth, y * blockHeight,
                        blockWidth, blockHeight, pixels, color, imageWidth);

                prevHeight = block.height;
            }
        }

        BufferedImage chunkImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        chunkImage.setRGB(0, 0, imageWidth, imageHeight, pixels, 0, imageWidth);

        return chunkImage;
    }

    private static void fillRect(int startX, int startY, int blockWidth,
                                int blockHeight, int[] pixels, int color, int imageWidth) {
        for (int y = 0; y < blockHeight; y++) {
            for (int x = 0; x < blockWidth; x++) {
                int pixelX = startX + x;
                int pixelY = startY + y;
                int index = pixelY * imageWidth + pixelX;

                // Убедимся, что не выходим за границы массива
                if (index >= 0 && index < pixels.length) {
                    pixels[index] = color;
                }
            }
        }
    }

    private static int modifyColorByHeight(int x, int y, int height, double prevHeight, int color) {
        int brightness;
        double heightDiff = (height - prevHeight) * 4.0D / (double) (1 + 4) + ((double) (x + y & 1) - 0.5D) * 0.4D;

        if (heightDiff > 0.6D) {
            brightness = 0;
        } else if (heightDiff < -0.6D) {
            brightness = 68;
        } else {
            brightness = 34;
        }

        return Colors.blend(brightness << 24, Colors.setAlpha(255, color));
    }

    private static int modifyColorByMetadata(BlockWithMetadata block, double prevHeight, int x, int y, int color) {
        Map<Class<? extends BlockMeta>, BlockMeta> metadata = block.getMetadata();

        if (metadata.containsKey(PlantMeta.class)) {
            PlantMeta meta = (PlantMeta) metadata.get(PlantMeta.class);

            if (!PlantBlockCollection.isGrassPlant(meta.getPlantType())) {
                color = MaterialColorCollection.getColor(meta.getPlantType());
            }
        }

        if (metadata.containsKey(UnderwaterMeta.class)) {
            int brightness;

            UnderwaterMeta meta = (UnderwaterMeta) metadata.get(UnderwaterMeta.class);
            short depth = meta.getDepth();
            double heightDiff = (double) depth * 0.1D + (double) (x + y & 1) * 0.2D;
            color = MaterialColorCollection.getColor(BlockType.WATER);

            if (heightDiff < 0.5D) {
                brightness = 0x00;
            } else if (heightDiff > 0.9D) {
                brightness = 0x44;
            } else {
                brightness = 0x22;
            }

            return Colors.blend(brightness << 24, Colors.setAlpha(255, color));
        }

        return modifyColorByHeight(x, y, block.getHeight(), prevHeight, color);
    }
}
