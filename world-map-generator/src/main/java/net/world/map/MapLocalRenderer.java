package net.world.map;

import net.world.map.loader.WorldLoader;
import net.world.map.renderer.WorldRenderer;
import net.world.map.structure.model.World;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class MapLocalRenderer {
    public static World readWorld() throws IOException {
        return WorldLoader.getWorld(Path.of("world-map-generator/src/main/resources/regions"));
    }

    public static void main(String[] args) throws IOException {
        World world = readWorld();
        BufferedImage worldMapImage = WorldRenderer.render(world);

        try {
            ImageIO.write(worldMapImage, "png", new File("world-map-generator/src/main/resources/", "world-map.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
