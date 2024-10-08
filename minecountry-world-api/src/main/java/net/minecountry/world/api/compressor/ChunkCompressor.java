package net.minecountry.world.api.compressor;

import net.minecountry.world.api.compressor.model.CompressedChunk;
import net.minecountry.world.api.structure.model.Block;
import net.minecountry.world.api.structure.model.Chunk;
import net.minecountry.world.api.structure.model.LayeredBlock;
import net.minecountry.world.api.structure.registries.BlockType;
import net.minecountry.world.api.structure.registries.PlantBlockRegistry;

public class ChunkCompressor {
    public static CompressedChunk compress(Chunk chunk) {
        Block[] blocks = chunk.getBlocks();
        CompressedChunk compressedChunk = new CompressedChunk();

        for (int i = 0; i < blocks.length; i++) {
            Block block = blocks[i];

            compressedChunk.setBlockLayer(0, block.getBlockType(), block.getHeight());

            if (block instanceof LayeredBlock layeredBlock) {
                short[] types = layeredBlock.getTypes();
                short[] heights = layeredBlock.getHeights();

                for (int j = 0; j < types.length; j++) {
                    short type = types[j];
                    short height = heights[j];

                    if (type == BlockType.WATER.getId()) {
                        compressedChunk.setWaterLayer(i, (short) (height - layeredBlock.getHeight()));
                    }

                    if (PlantBlockRegistry.isPlant(BlockType.getById(type))) {
                        compressedChunk.setPlantLayer(i, type, height);
                    }
                }
            }
        }

        return compressedChunk;
    }
}
