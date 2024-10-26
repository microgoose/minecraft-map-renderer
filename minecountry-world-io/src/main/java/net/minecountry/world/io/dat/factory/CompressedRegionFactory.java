package net.minecountry.world.io.dat.factory;

import net.minecountry.world.api.model.Chunk;
import net.minecountry.world.api.model.Region;
import net.minecountry.world.io.dat.model.CompressedRegion;

public class CompressedRegionFactory {
    public static CompressedRegion build(Region region) {
        CompressedRegion compressedRegion = new CompressedRegion();
        Chunk[] chunks = region.getChunks();

        for (short i = 0; i < chunks.length; i++) {
            Chunk chunk = chunks[i];

            if (chunk == null)
                continue;

            compressedRegion.addChunk(i, CompressedChunkFactory.build(chunks[i]));
        }

        return compressedRegion;
    }
}
