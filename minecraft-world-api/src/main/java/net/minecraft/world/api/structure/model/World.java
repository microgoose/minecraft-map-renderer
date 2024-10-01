package net.minecraft.world.api.structure.model;

import net.minecraft.world.api.structure.config.ChunkConfig;
import net.minecraft.world.api.structure.config.RegionConfig;
import net.minecraft.world.api.structure.utils.PointsMap;

public class World {
    PointsMap<Region> regions = new PointsMap<>();

    public Region getRegionByLocal(int regionX, int regionY) {
        return regions.get(regionX, regionY);
    }

    public Region getRegionAt(int globalX, int globalY) {
        int regionX = Math.floorDiv(globalX, RegionConfig.REGION_AREA);
        int regionY = Math.floorDiv(globalY, RegionConfig.REGION_AREA);

        return regions.get(regionX, regionY);
    }

    public Block getBlockAt(int globalX, int globalY) {
        Region region = getRegionAt(globalX, globalY);

        if (region == null)
            return null;

        return region.getBlockAt(globalX, globalY);
    }

    public PointsMap<Region> getRegions() {
        return regions;
    }

    public int getWidth() {
        return regions.getWidth() * RegionConfig.REGION_SIZE * ChunkConfig.CHUNK_SIZE;
    }

    public int getHeight() {
        return regions.getHeight() * RegionConfig.REGION_SIZE * ChunkConfig.CHUNK_SIZE;
    }

    public void addRegion(Region region) {
        regions.set(region.getX(), region.getY(), region);
    }
}
