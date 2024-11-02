package net.minecountry.world.api.locators;

import net.minecountry.world.api.config.ChunkConfig;
import net.minecountry.world.api.config.RegionConfig;
import net.minecountry.world.api.model.Chunk;
import net.minecountry.world.api.model.Region;

public class ChunkLocator {
    public static Chunk getAtLocal(Region region, int localX, int localY) {
        return region.getChunk(getIndex(localX, localY));
    }

    public static Chunk getAtGlobal(Region region, int globalX, int globalY) {
        int chunkX = Math.floorDiv(globalX, ChunkConfig.BLOCKS_SIDE);
        int chunkY = Math.floorDiv(globalY, ChunkConfig.BLOCKS_SIDE);
        int localX = Math.floorMod(chunkX, RegionConfig.CHUNK_SIDE);
        int localY = Math.floorMod(chunkY, RegionConfig.CHUNK_SIDE);
        return getAtLocal(region, localX, localY);
    }

    private static int getIndex(int localX, int localY) {
        return localX + localY * RegionConfig.CHUNK_SIDE;
    }
}
