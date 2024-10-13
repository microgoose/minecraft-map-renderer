package net.minecountry.renderer;

import net.minecountry.renderer.config.RenderConfig;
import net.minecountry.world.api.common.Point;
import net.minecountry.world.api.common.PointsMap;
import net.minecountry.world.api.model.Region;
import net.minecountry.world.api.model.World;

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

            int xPos = (region.getRegionX() - regionsMap.getMinX()) * regionImage.getWidth();
            int yPos = (region.getRegionY() - regionsMap.getMinY()) * regionImage.getHeight();

            graphics.drawImage(regionImage, xPos, yPos, null);
            graphics.drawRect(xPos, yPos, xPos + regionImage.getWidth(), yPos + regionImage.getHeight());
        }

        graphics.dispose();

        return worldMapImage;
    }
}
