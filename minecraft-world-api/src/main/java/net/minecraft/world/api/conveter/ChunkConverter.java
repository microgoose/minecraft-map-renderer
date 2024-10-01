package net.minecraft.world.api.conveter;

import net.minecraft.world.api.structure.registries.BlockTypeRegistry;
import net.minecraft.world.api.conveter.model.CompressedChunk;
import net.minecraft.world.api.structure.model.Block;
import net.minecraft.world.api.structure.model.BlockWithMetadata;
import net.minecraft.world.api.structure.model.Chunk;
import net.minecraft.world.api.structure.model.metadata.BlockMeta;
import net.minecraft.world.api.structure.model.metadata.PlantMeta;
import net.minecraft.world.api.structure.model.metadata.UnderwaterMeta;

import java.util.Map;

public class ChunkConverter {
    public static void compress(Chunk chunk) {
        Block[] blocks = chunk.getBlocks();
        CompressedChunk compressedChunk = new CompressedChunk();

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
