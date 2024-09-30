package net.world.map.loader;

import net.world.map.loader.parser.RegionParser;
import net.world.map.structure.model.Region;
import net.world.map.structure.model.World;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class WorldLoader {
    public static World getWorld(Path regionsDirectory) throws IOException {
        File regDir = regionsDirectory.toFile();

        if (!regDir.exists()) {
            throw new IllegalArgumentException("Region directory does not exist: " + regDir);
        }

        if (!regDir.isDirectory()) {
            throw new IllegalArgumentException("Region directory is not a directory: " + regDir);
        }

        File[] regionFiles = regDir.listFiles();

        if (regionFiles == null) {
            throw new IllegalArgumentException("Region directory contains no region files: " + regDir);
        }

        World world = new World();

        for (File regionFile : regionFiles) {
            Optional<Region> regionOpt = RegionParser.parse(regionFile);
            regionOpt.ifPresent(world::addRegion);
        }

        return world;
    }
}
