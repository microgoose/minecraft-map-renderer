package net.minecraft.world.api.renderer;

import net.minecraft.world.api.structure.model.World;
import net.minecraft.world.api.renderer.config.RenderConfig;
import net.minecraft.world.api.structure.model.Point;
import net.minecraft.world.api.structure.model.Region;
import net.minecraft.world.api.structure.utils.PointsMap;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class WorldRenderer {
    public static BufferedImage render(World world) {
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
