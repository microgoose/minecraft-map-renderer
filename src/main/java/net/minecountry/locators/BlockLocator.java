package net.minecountry.locators;

import net.minecountry.config.ChunkConfig;
import net.minecountry.model.Block;
import net.minecountry.model.Chunk;
import net.minecountry.model.Region;
import net.minecountry.model.World;

public class BlockLocator {
    public static Block getAtLocal(Chunk chunk, int localX, int localY) {
        return chunk.getBlock(getIndex(localX, localY));
    }

    public static Block getAtGlobal(Chunk chunk, int globalX, int globalY) {
        int localX = Math.floorMod(globalX, ChunkConfig.BLOCKS_SIDE);
        int localY = Math.floorMod(globalY, ChunkConfig.BLOCKS_SIDE);
        return getAtLocal(chunk, localX, localY);
    }

    public static Block getAtGlobal(Region region, int globalX, int globalY) {
        Chunk chunk = ChunkLocator.getAtGlobal(region, globalX, globalY);

        if (chunk == null)
            return null;

        return getAtGlobal(chunk, globalX, globalY);
    }

    public static Block getAtGlobal(World world, int globalX, int globalY) {
        Region region = RegionLocator.getAtGlobal(world, globalX, globalY);

        if (region == null)
            return null;

        return getAtGlobal(region, globalX, globalY);
    }

    private static int getIndex(int localX, int localY) {
        return localX + localY * ChunkConfig.BLOCKS_SIDE;
    }
}
