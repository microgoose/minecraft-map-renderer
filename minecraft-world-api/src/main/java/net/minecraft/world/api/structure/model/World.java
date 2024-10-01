package net.minecraft.world.api.structure.model;

import net.minecraft.world.api.structure.config.ChunkConfig;
import net.minecraft.world.api.structure.config.RegionConfig;
import net.minecraft.world.api.structure.utils.PointsMap;

public class World {
    PointsMap<Region> regions = new PointsMap<>();

    public Region getRegionAt(int x, int y) {
        int regionX = Math.floorDiv(x, RegionConfig.REGION_AREA);
        int regionY = Math.floorDiv(y, RegionConfig.REGION_AREA);

        return regions.get(regionX, regionY);
    }

    public Block getBlockAt(int x, int y) {
        Region region = getRegionAt(x, y);

        if (region == null)
            return null;

        return region.getBlockAt(x, y);
    }

    public PointsMap<Region> getRegions() {
        return regions;
    }

    public Integer getWidth() {
        return regions.getWidth() * RegionConfig.REGION_SIZE * ChunkConfig.CHUNK_SIZE;
    }

    public Integer getHeight() {
        return regions.getHeight() * RegionConfig.REGION_SIZE * ChunkConfig.CHUNK_SIZE;
    }

    public void addRegion(Region region) {
        regions.set(region.getX(), region.getY(), region);
    }
}
