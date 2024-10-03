package net.minecraft.world.converter;

import net.minecraft.world.api.compressor.RegionCompressor;
import net.minecraft.world.api.compressor.model.CompressedRegion;
import net.minecraft.world.api.structure.model.Point;
import net.minecraft.world.api.structure.model.Region;

import java.nio.file.Path;
import java.util.Optional;

public class WorldConverter {
    private static final String REGION_PATH_ARG = "-source-dir";
    private static final String DESTINATION_PATH_ARG = "-destination-dir";

    public static void main(String[] args) {
        if (args.length != 2)
            throw new RuntimeException("Usage: WorldConverter -source-dir=<PATH> -destination-dir=<PATH>");

        String regionsPathArg = args[0].substring(REGION_PATH_ARG.length() + 1);
        String destinationPathArg = args[1].substring(DESTINATION_PATH_ARG.length() + 1);
        RegionReader reader = new RegionReader(getDir(regionsPathArg));
        RegionWriter writer = new RegionWriter(getDir(destinationPathArg));

        for (Point regionPoint : reader.getRegionPoints()) {
            Optional<Region> regionOptional = reader.loadRegion(regionPoint);

            if (regionOptional.isEmpty()) {
                continue;
            }

            CompressedRegion compressedRegion = RegionCompressor.convert(regionOptional.get());
            writer.write(regionPoint, compressedRegion);
        }

        System.out.println("Converted " + regionsPathArg + " to " + destinationPathArg);
    }

    private static Path getDir(String dirPathString) {
        Path dirPath = Path.of(dirPathString);

        if (!dirPath.toFile().exists())
            throw new IllegalArgumentException("Directory does not exist: " + dirPathString);
        if (dirPath.toFile().isFile())
            throw new IllegalArgumentException("Directory is a file: " + dirPathString);

        return dirPath;
    }
}
