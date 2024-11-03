package net.minecraft.map.converter;

import net.minecraft.map.core.model.Region;
import net.minecraft.map.core.model.World;
import net.minecraft.map.renderer.common.RenderBlockFilter;
import net.minecraft.map.renderer.common.RenderBlockLayerFilter;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

public class WorldConverter {
    public static World convert(Path regionsDir)  {
        File[] regionFiles = getRegionFiles(regionsDir);

        World world = new World();
        ChunkConverter chunkConverter = new ChunkConverter(new RenderBlockFilter(), new RenderBlockLayerFilter());
        RegionConverter regionConverter = new RegionConverter(chunkConverter);

        for (File regionFile : regionFiles) {
            Optional<Region> regionOpt = regionConverter.convert(regionFile);
            regionOpt.ifPresent(world::addRegion);
        }

        return world;
    }

    private static File[] getRegionFiles(Path regionsDir) {
        File regDir = regionsDir.toFile();

        if (!regDir.exists())
            throw new IllegalArgumentException("Region directory does not exist: " + regDir);
        if (!regDir.isDirectory())
            throw new IllegalArgumentException("Region directory is not a directory: " + regDir);

        File[] regionFiles = regDir.listFiles();

        if (regionFiles == null)
            throw new IllegalArgumentException("Region directory contains no region files: " + regDir);

        return regionFiles;
    }
}
