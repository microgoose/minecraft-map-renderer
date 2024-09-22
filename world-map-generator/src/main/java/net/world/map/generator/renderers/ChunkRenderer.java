package net.world.map.generator.renderers;

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
import java.util.HashMap;
import java.util.Map;

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
                Map<Class<? extends BlockMeta>, BlockMeta> metadata = new HashMap<>();

                if (block instanceof BlockWithMetadata blockWithMetadata) {
                    metadata = blockWithMetadata.getMetadata();
                }

                int height = block.getHeight();
                int brightness;
                int color = MaterialColorCollection.getColor(block.getBlockType());

                if (metadata.containsKey(PlantMeta.class)) {
                    PlantMeta meta = (PlantMeta) metadata.get(PlantMeta.class);

                    if (!PlantBlockCollection.isGrassPlant(meta.getPlantType())) {
                        color = MaterialColorCollection.getColor(meta.getPlantType());
                    }
                }

                if (metadata.containsKey(UnderwaterMeta.class)) {
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
                } else {
                    double heightDiff = (height - lastBlockHeight) * 4.0D / (double) (1 + 4) + ((double) (x + y & 1) - 0.5D) * 0.4D;

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
