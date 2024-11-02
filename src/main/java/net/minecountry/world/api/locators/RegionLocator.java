package net.minecountry.world.api.locators;

import net.minecountry.world.api.common.PointsMap;
import net.minecountry.world.api.config.RegionConfig;
import net.minecountry.world.api.model.Region;
import net.minecountry.world.api.model.World;

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
