package net.minecountry;

import net.minecountry.model.LazyWorld;

import java.nio.file.Path;

public class WorldConverter {
    //TODO temporary solution
    private static final Path regionsPath = Path.of("minecraft-world-2d-converter/src/main/resources/regions");

    public static void main(String[] args) {
        LazyWorld lazyWorld = new LazyWorld(regionsPath);

        System.out.println("Done");
    }
}
