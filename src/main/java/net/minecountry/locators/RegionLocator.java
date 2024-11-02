package net.minecountry.locators;

import net.minecountry.common.PointsMap;
import net.minecountry.config.RegionConfig;
import net.minecountry.model.Region;
import net.minecountry.model.World;

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
