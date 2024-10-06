package net.minecountry.world.api.compressor;

import net.minecountry.world.api.compressor.model.CompressedChunk;
import net.minecountry.world.api.compressor.model.CompressedRegion;
import net.minecountry.world.api.structure.config.RegionConfig;
import net.minecountry.world.api.structure.model.Chunk;
import net.minecountry.world.api.structure.model.Region;

public class RegionCompressor {
    public static CompressedRegion convert(Region region) {
        CompressedRegion compressedRegion = new CompressedRegion();

        for (short index = 0; index < RegionConfig.CHUNKS_COUNT; index++) {
            Chunk chunk = region.getChunk(index);

            if (chunk == null)
                continue;

            CompressedChunk compressedChunk = ChunkCompressor.compress(chunk);
            compressedRegion.addChunk(index, compressedChunk);
        }

        return compressedRegion;
    }
}
