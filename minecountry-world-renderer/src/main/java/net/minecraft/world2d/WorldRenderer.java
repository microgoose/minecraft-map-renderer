package net.minecraft.world2d;

import net.minecraft.world.api.loader.WorldLoader;
import net.minecraft.world.api.structure.model.Point;
import net.minecraft.world.api.structure.model.Region;
import net.minecraft.world.api.structure.model.World;
import net.minecraft.world.api.structure.utils.PointsMap;
import net.minecraft.world2d.config.RenderConfig;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.util.Map;

public class WorldRenderer {
    public static void main(String[] args) {
        World world = readWorld();
        BufferedImage worldMapImage = render(world);

        try {
            ImageIO.write(worldMapImage, "png", new File("minecraft-world-2d-renderer/src/main/resources/", "world-map.png"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private static World readWorld()  {
        return WorldLoader.getWorld(Path.of("minecraft-world-2d-renderer/src/main/resources/regions"));
    }

    private static BufferedImage render(World world) {
        BufferedImage worldMapImage = new BufferedImage(
            world.getWidth() * RenderConfig.RENDER_SCALE,
            world.getHeight() * RenderConfig.RENDER_SCALE,
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D graphics = worldMapImage.createGraphics();

        graphics.setColor(Color.BLACK);

        PointsMap<Region> regionsMap = world.getRegions();

        for (Map.Entry<Point, Region> entry : regionsMap.getMap().entrySet()) {
            Region region = entry.getValue();
            BufferedImage regionImage = RegionRenderer.render(world, region);

            int xPos = (region.getX() - regionsMap.getMinX()) * regionImage.getWidth();
            int yPos = (region.getY() - regionsMap.getMinY()) * regionImage.getHeight();

            graphics.drawImage(regionImage, xPos, yPos, null);
            graphics.drawRect(xPos, yPos, xPos + regionImage.getWidth(), yPos + regionImage.getHeight());
        }

        graphics.dispose();

        return worldMapImage;
    }
}
