package net.minecraft.map.core.locators;

import net.minecraft.map.core.common.PointsMap;
import net.minecraft.map.core.config.RegionConfig;
import net.minecraft.map.core.model.Region;
import net.minecraft.map.core.model.World;

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
