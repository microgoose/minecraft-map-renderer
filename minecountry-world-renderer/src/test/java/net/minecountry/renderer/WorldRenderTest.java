package net.minecountry.renderer;

import net.minecountry.renderer.common.RenderBlockFilter;
import net.minecountry.renderer.common.RenderBlockLayerFilter;
import net.minecountry.world.api.model.Region;
import net.minecountry.world.api.model.World;
import net.minecountry.world.io.mca.deserializer.ChunkDeserializer;
import net.minecountry.world.io.mca.deserializer.RegionDeserializer;
import net.minecountry.world.io.mca.reader.RegionReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

public class WorldRenderTest {
    public static final String pathToRegionsFolder = "minecountry-world-renderer/src/test/resources/regions";
    public static final String pathToImage = "minecountry-world-renderer/src/test/resources";

    public static void main(String[] args) {
        World world = readWorld();
        BufferedImage worldMapImage = WorldRenderer.render(world);

        try {
            ImageIO.write(worldMapImage, "png", new File(pathToImage, "world-map.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static World readWorld()  {
        File regDir = Path.of(pathToRegionsFolder).toFile();

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
