package net.minecraft.world.api.compressor;

import net.minecraft.world.api.compressor.model.CompressedChunk;
import net.minecraft.world.api.compressor.model.CompressedRegion;
import net.minecraft.world.api.structure.config.RegionConfig;
import net.minecraft.world.api.structure.model.Chunk;
import net.minecraft.world.api.structure.model.Region;

public class RegionCompressor {
    public static CompressedRegion convert(Region region) {
        CompressedRegion compressedRegion = new CompressedRegion();

        for (short index = 0; index < RegionConfig.REGION_MAX_CHUNKS_COUNT; index++) {
            Chunk chunk = region.getChunkByIndex(index);

            if (chunk == null)
                continue;

            CompressedChunk compressedChunk = ChunkCompressor.compress(chunk);
            compressedRegion.addChunk(index, compressedChunk);
        }

        return compressedRegion;
    }
}
