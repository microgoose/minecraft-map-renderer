package net.minecraft.map;

import net.minecraft.map.converter.WorldConverter;
import net.minecraft.map.core.model.World;
import net.minecraft.map.saver.WorldMapSaver;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: java -jar your-app.jar <pathToRegionsFolder> <pathToOutputFolder>");
            System.exit(1);
        }

        String pathToRegionsFolder = args[0];
        String pathToImage = args[1];

        World world = WorldConverter.convert(Path.of(pathToRegionsFolder));
        WorldMapSaver.save(world, Path.of(pathToImage));
    }
}