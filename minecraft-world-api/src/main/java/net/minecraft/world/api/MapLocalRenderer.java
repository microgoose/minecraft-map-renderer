package net.minecraft.world.api;

import net.minecraft.world.api.loader.WorldLoader;
import net.minecraft.world.api.renderer.WorldRenderer;
import net.minecraft.world.api.structure.model.World;

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
