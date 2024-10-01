package net.minecraft.world.api.loader;

import net.minecraft.world.api.structure.model.World;
import net.minecraft.world.api.loader.parser.RegionParser;
import net.minecraft.world.api.structure.model.Region;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class WorldLoader {
    public static World getWorld(Path regionsDirectory) {
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
