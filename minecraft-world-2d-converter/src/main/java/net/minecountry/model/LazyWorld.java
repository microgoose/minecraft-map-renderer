package net.minecountry.model;

import net.minecraft.world.api.loader.parser.RegionParser;
import net.minecraft.world.api.structure.config.RegionConfig;
import net.minecraft.world.api.structure.model.Block;
import net.minecraft.world.api.structure.model.Point;
import net.minecraft.world.api.structure.model.Region;
import net.minecraft.world.api.structure.model.World;
import net.minecraft.world.api.structure.utils.PointsMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class LazyWorld {
    public final World world = new World();
    private final Path regionsPath;
    private final Map<Point, Path> regions = new HashMap<>();

    public LazyWorld(Path regionsPath) {
        this.regionsPath = regionsPath;

        try (Stream<Path> paths = Files.list(regionsPath)) {
            paths.filter(Files::isRegularFile)
                    .forEach(path -> {
                        Point regionPoint = RegionParser.getRegionPoint(path.getFileName().toString());
                        regions.put(regionPoint, path);
                    });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Region getRegionAt(int globalX, int globalY) {
        int regionX = Math.floorDiv(globalX, RegionConfig.REGION_AREA);
        int regionY = Math.floorDiv(globalY, RegionConfig.REGION_AREA);

        Region region  = world.getRegionByLocal(globalX, globalY);

        if (region == null) {
            Path regionPath = regions.get(new Point(regionX, regionY));
            Optional<Region> loadedRegion = RegionParser.parse(regionPath);

            if (loadedRegion.isPresent()) {
                region = loadedRegion.get();
                world.addRegion(region);
            }
        }

        return region;
    }

    public Block getBlockAt(int globalX, int globalY) {
        Region region = getRegionAt(globalX, globalY);

        if (region == null)
            return null;

        return region.getBlockAt(globalX, globalY);
    }

    public PointsMap<Region> getRegions() {
        return world.getRegions();
    }

    public int getWidth() {
        return world.getWidth();
    }

    public int getHeight() {
        return world.getHeight();
    }

    public void addRegion(Point point, Path regionPath) {
        regions.put(point, regionPath);
    }
}
