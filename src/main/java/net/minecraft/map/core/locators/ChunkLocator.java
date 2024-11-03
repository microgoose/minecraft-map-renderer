package net.minecraft.map.core.locators;

import net.minecraft.map.core.config.ChunkConfig;
import net.minecraft.map.core.config.RegionConfig;
import net.minecraft.map.core.model.Chunk;
import net.minecraft.map.core.model.Region;

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
