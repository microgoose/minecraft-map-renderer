package net.minecraft.world.converter;

import net.minecraft.world.api.compressor.model.CompressedRegion;
import net.minecraft.world.api.structure.model.Point;

import java.nio.file.Path;

public class RegionWriter {
    private final Path destination;

    public RegionWriter(Path destination) {
        this.destination = destination;
    }

    public void write(Point regionPoint, CompressedRegion region) {
        //TODO pack to .dat
    }
}
