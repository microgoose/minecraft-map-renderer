package net.minecountry.world.io;

import net.minecountry.world.api.common.Point;
import net.minecountry.world.api.loader.parser.RegionParser;
import net.minecountry.world.api.structure.model.Region;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class MCARegionReader {
    private final Map<Point, Path> regions = new HashMap<>();

    public MCARegionReader(Path regionsPath) {
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
