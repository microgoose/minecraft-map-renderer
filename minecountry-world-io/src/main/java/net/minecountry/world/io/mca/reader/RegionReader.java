package net.minecountry.world.io.mca.reader;

import net.minecountry.world.api.model.Region;
import net.minecountry.world.io.mca.deserializer.RegionDeserializer;

import java.io.File;
import java.util.Optional;

public class RegionReader {
    public static Optional<Region> read(RegionDeserializer deserializer, File regionFile) {
        return deserializer.deserialize(regionFile);
    }
}
