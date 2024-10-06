package net.minecountry.world.api.structure.service;

import net.minecountry.world.api.structure.config.ChunkConfig;
import net.minecountry.world.api.structure.model.Block;
import net.minecountry.world.api.structure.model.Chunk;
import net.minecountry.world.api.structure.model.Region;
import net.minecountry.world.api.structure.model.World;

public class BlockService {
    public static Block getAtLocal(Chunk chunk, int localX, int localY) {
        return chunk.getBlock(getIndex(localX, localY));
    }

    public static Block getAtGlobal(Chunk chunk, int globalX, int globalY) {
        int localX = Math.floorMod(globalX, ChunkConfig.BLOCKS_SIDE);
        int localY = Math.floorMod(globalY, ChunkConfig.BLOCKS_SIDE);
        return getAtLocal(chunk, localX, localY);
    }

    public static Block getAtGlobal(Region region, int globalX, int globalY) {
        Chunk chunk = ChunkService.getAtGlobal(region, globalX, globalY);

        if (chunk == null)
            return null;

        return getAtGlobal(chunk, globalX, globalY);
    }

    public static Block getAtGlobal(World world, int globalX, int globalY) {
        Region region = RegionService.getAtGlobal(world, globalX, globalY);

        if (region == null)
            return null;

        return getAtGlobal(region, globalX, globalY);
    }

    private static int getIndex(int localX, int localY) {
        return localX + localY * ChunkConfig.BLOCKS_SIDE;
    }
}
