package net.minecountry.world.api.structure.service;

import net.minecountry.world.api.common.PointsMap;
import net.minecountry.world.api.structure.config.RegionConfig;
import net.minecountry.world.api.structure.model.Region;
import net.minecountry.world.api.structure.model.World;

public class RegionLocator {
    public static Region getAtLocal(World world, int localX, int LocalY) {
        return world.getRegions().get(localX, LocalY);
    }

    public static Region getAtGlobal(World world, int globalX, int globalY) {
        PointsMap<Region> regions = world.getRegions();
        int regionX = Math.floorDiv(globalX, RegionConfig.BLOCKS_SIDE);
        int regionY = Math.floorDiv(globalY, RegionConfig.BLOCKS_SIDE);

        return regions.get(regionX, regionY);
    }
}
