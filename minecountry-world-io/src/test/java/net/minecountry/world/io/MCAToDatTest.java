package net.minecountry.world.io;

import net.minecountry.world.api.compressor.RegionCompressor;
import net.minecountry.world.api.compressor.model.CompressedRegion;
import net.minecountry.world.api.structure.model.Point;
import net.minecountry.world.api.structure.model.Region;

import java.nio.file.Path;
import java.util.Optional;

public class MCAToDatTest {
    public static final Path REGION_PATH = Path.of("minecountry-world-io/src/test/resources/regions");
    public static final Path DESTINATION_PATH = Path.of("minecountry-world-io/src/test/resources/converted");

    public static void main(String[] args) {
        MCARegionReader reader = new MCARegionReader(getDir(REGION_PATH));
        RegionWriter writer = new RegionWriter(getDir(DESTINATION_PATH));

        for (Point regionPoint : reader.getRegionPoints()) {
            Optional<Region> regionOptional = reader.loadRegion(regionPoint);

            if (regionOptional.isEmpty()) {
                continue;
            }

            CompressedRegion compressedRegion = RegionCompressor.convert(regionOptional.get());
            writer.write(regionPoint, compressedRegion);
        }

        System.out.println("Converted " + REGION_PATH + " to " + DESTINATION_PATH);
    }

    private static Path getDir(Path dirPath) {
        if (!dirPath.toFile().exists())
            throw new IllegalArgumentException("Directory does not exist: " + dirPath);
        if (dirPath.toFile().isFile())
            throw new IllegalArgumentException("Directory is a file: " + dirPath);

        return dirPath;
    }
}
