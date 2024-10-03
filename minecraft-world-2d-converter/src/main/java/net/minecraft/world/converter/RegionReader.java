package net.minecraft.world.converter;

import net.minecraft.world.api.loader.parser.RegionParser;
import net.minecraft.world.api.structure.model.Point;
import net.minecraft.world.api.structure.model.Region;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class RegionReader {
    private final Map<Point, Path> regions = new HashMap<>();

    public RegionReader(Path regionsPath) {
        try (Stream<Path> paths = Files.list(regionsPath)) {
            paths.filter(Files::isRegularFile).forEach(path -> {
                Point regionPoint = RegionParser.getRegionPoint(path.getFileName().toString());
                regions.put(regionPoint, path);
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Optional<Region> loadRegion(Point regionPoint) {
        Path regionPath = regions.get(regionPoint);

        if (regionPath == null)
            throw new RuntimeException("Region not found: " + regionPoint);

        return RegionParser.parse(regionPath);
    }

    public Set<Point> getRegionPoints() {
        return regions.keySet();
    }
}
