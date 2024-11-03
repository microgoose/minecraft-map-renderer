package net.minecraft.map.saver;

import net.minecraft.map.core.common.Point;
import net.minecraft.map.core.common.PointsMap;
import net.minecraft.map.core.model.Region;
import net.minecraft.map.core.model.World;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class WorldMapSaver {
    public static void save(World world, Path outputPath) throws IOException {
        PointsMap<Region> regionsMap = world.getRegions();
        File outputDir = outputPath.toFile();

        if (!outputDir.exists())
            throw new RuntimeException("Output directory does not exist: " + outputDir.getAbsolutePath());
        if (!outputDir.isDirectory())
            throw new RuntimeException("Output directory is not a directory: " + outputDir.getAbsolutePath());
        if (!outputDir.canWrite())
            throw new RuntimeException("Output directory is not writable: " + outputDir.getAbsolutePath());

        for (Map.Entry<Point, Region> entry : regionsMap.getMap().entrySet()) {
            RegionImageSaver.save(world, entry.getValue(), outputDir);
        }
    }
}
