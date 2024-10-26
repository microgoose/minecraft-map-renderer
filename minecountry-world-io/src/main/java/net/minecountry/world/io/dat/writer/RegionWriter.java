package net.minecountry.world.io.dat.writer;

import net.minecountry.world.api.model.Region;
import net.minecountry.world.io.dat.factory.CompressedRegionFactory;
import net.minecountry.world.io.dat.model.CompressedRegion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;

public class RegionWriter {
    public static void write(Path regionPath, Region region) {
        CompressedRegion compressedRegion = CompressedRegionFactory.build(region);

        try (FileOutputStream fileOut = new FileOutputStream(regionPath.toFile())) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(compressedRegion);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
