package net.minecraft.map.core.model;

import net.minecraft.map.core.common.PointsMap;
import net.minecraft.map.core.config.ChunkConfig;
import net.minecraft.map.core.config.RegionConfig;

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