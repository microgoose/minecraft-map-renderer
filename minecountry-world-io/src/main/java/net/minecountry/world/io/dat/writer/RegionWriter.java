package net.minecountry.world.io.dat.writer;

import net.minecountry.world.api.model.Region;
import net.minecountry.world.io.dat.convertor.RegionConvertor;
import net.minecountry.world.io.dat.factory.CompressedRegionFactory;
import net.minecountry.world.io.dat.model.CompressedRegion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegionWriter {
    public static void write(File regionFile, Region region) {
        CompressedRegion compressedRegion = CompressedRegionFactory.build(region);

        try (FileOutputStream fileStream = new FileOutputStream(regionFile)) {
            fileStream.write(RegionConvertor.toByteArray(compressedRegion));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
