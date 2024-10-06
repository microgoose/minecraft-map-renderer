package net.minecountry.world.api.structure.model;

import net.minecountry.world.api.common.PointsMap;
import net.minecountry.world.api.structure.config.ChunkConfig;
import net.minecountry.world.api.structure.config.RegionConfig;

public class World {
    PointsMap<Region> regions = new PointsMap<>();

    public PointsMap<Region> getRegions() {
        return regions;
    }

    public int getWidth() {
        return regions.getWidth() * RegionConfig.CHUNK_SIDE * ChunkConfig.BLOCKS_SIDE;
    }

    public int getHeight() {
        return regions.getHeight() * RegionConfig.CHUNK_SIDE * ChunkConfig.BLOCKS_SIDE;
    }

    public void addRegion(Region region) {
        regions.set(region.getRegionX(), region.getRegionY(), region);
    }
}
