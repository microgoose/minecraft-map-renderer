package net.world.map.conveter;

import net.world.map.conveter.model.CompressedChunk;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.BlockWithMetadata;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.metadata.BlockMeta;
import net.world.map.structure.model.metadata.PlantMeta;
import net.world.map.structure.model.metadata.UnderwaterMeta;
import net.world.map.structure.registries.BlockTypeRegistry;

import java.util.Map;

public class ChunkConverter {
    public static void compress(Chunk chunk) {
        Block[] blocks = chunk.getBlocks();
        CompressedChunk compressedChunk = new CompressedChunk();

        //TODO interface for loader
        //TODO saving to files

        for (int i = 0; i < blocks.length; i++) {
            Block block = blocks[i];

            compressedChunk.setBlockLayer(0, BlockTypeRegistry.getId(block.getBlockType()), block.getHeight());

            if (block instanceof BlockWithMetadata blockWithMetadata) {
                Map<Class<? extends BlockMeta>, BlockMeta> metadata = blockWithMetadata.getMetadata();

                if (metadata.containsKey(UnderwaterMeta.class)) {
                    UnderwaterMeta underwaterMeta = (UnderwaterMeta) metadata.get(UnderwaterMeta.class);
                    compressedChunk.setWaterLayer(i, underwaterMeta.getDepth());
                }

                if (metadata.containsKey(PlantMeta.class)) {
                    PlantMeta plantMeta = (PlantMeta) metadata.get(PlantMeta.class);
                    compressedChunk.setPlantLayer(i, BlockTypeRegistry.getId(plantMeta.getPlantType()), plantMeta.getPlantHeight());
                }
            }
        }
    }
}
