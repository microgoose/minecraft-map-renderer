package net.minecountry.world.api.compressor;

import net.minecountry.world.api.compressor.model.CompressedChunk;
import net.minecountry.world.api.structure.model.Block;
import net.minecountry.world.api.structure.model.BlockWithMetadata;
import net.minecountry.world.api.structure.model.Chunk;
import net.minecountry.world.api.structure.model.metadata.BlockMeta;
import net.minecountry.world.api.structure.model.metadata.PlantMeta;
import net.minecountry.world.api.structure.model.metadata.UnderwaterMeta;

import java.util.Map;

public class ChunkCompressor {
    public static CompressedChunk compress(Chunk chunk) {
        Block[] blocks = chunk.getBlocks();
        CompressedChunk compressedChunk = new CompressedChunk();

        for (int i = 0; i < blocks.length; i++) {
            Block block = blocks[i];

            compressedChunk.setBlockLayer(0, block.getBlockType(), block.getHeight());

            if (block instanceof BlockWithMetadata blockWithMetadata) {
                Map<Class<? extends BlockMeta>, BlockMeta> metadata = blockWithMetadata.getMetadata();

                if (metadata.containsKey(UnderwaterMeta.class)) {
                    UnderwaterMeta underwaterMeta = (UnderwaterMeta) metadata.get(UnderwaterMeta.class);
                    compressedChunk.setWaterLayer(i, underwaterMeta.getDepth());
                }

                if (metadata.containsKey(PlantMeta.class)) {
                    PlantMeta plantMeta = (PlantMeta) metadata.get(PlantMeta.class);
                    compressedChunk.setPlantLayer(i, plantMeta.getPlantType(), plantMeta.getPlantHeight());
                }
            }
        }

        return compressedChunk;
    }
}
