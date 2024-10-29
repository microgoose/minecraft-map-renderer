package net.minecountry.world.io;

import net.minecountry.world.api.common.Point;
import net.minecountry.world.api.common.PointsMap;
import net.minecountry.world.api.model.Region;
import net.minecountry.world.api.model.World;
import net.minecountry.world.io.common.RenderBlockFilter;
import net.minecountry.world.io.common.RenderBlockLayerFilter;
import net.minecountry.world.io.dat.writer.RegionWriter;
import net.minecountry.world.io.mca.deserializer.ChunkDeserializer;
import net.minecountry.world.io.mca.deserializer.RegionDeserializer;
import net.minecountry.world.io.mca.reader.RegionReader;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;

public class MCAToDatTest {
    public static final Path REGION_PATH = Path.of("minecountry-world-io/src/test/resources/regions");
    public static final Path DESTINATION_PATH = Path.of("minecountry-world-io/src/test/resources/converted");

    public static void main(String[] args) {
        World world = readWorld();
        writeToDAT(world);
        System.out.println("Converted " + REGION_PATH + " to " + DESTINATION_PATH);
    }

    private static void writeToDAT(World world) {
        PointsMap<Region> regions = world.getRegions();

        for (Map.Entry<Point, Region> entry : regions.getMap().entrySet()) {
            Point point = entry.getKey();
            Path path = DESTINATION_PATH.resolve(String.format("%s.%s.dat", point.getX(), point.getY()));
            File regionFile = path.toFile();
            Region region = entry.getValue();

            RegionWriter.write(regionFile, region);
        }
    }

    //TODO remove duplicate
    private static World readWorld()  {
        File regDir = REGION_PATH.toFile();

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
        ChunkDeserializer chunkDeserializer =
                new ChunkDeserializer(new RenderBlockFilter(), new RenderBlockLayerFilter());
        RegionDeserializer regionDeserializer = new RegionDeserializer(chunkDeserializer);

        for (File regionFile : regionFiles) {
            Optional<Region> regionOpt = RegionReader.read(regionDeserializer, regionFile);
            regionOpt.ifPresent(world::addRegion);
        }

        return world;
    }
}
