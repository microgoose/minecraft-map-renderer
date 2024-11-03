package net.minecraft.map.saver;

import net.minecraft.map.core.model.Region;
import net.minecraft.map.core.model.World;
import net.minecraft.map.renderer.RegionRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RegionImageSaver {
    public static void save(World world, Region region, File outputDir) throws IOException {
        BufferedImage regionImage = RegionRenderer.render(world, region);
        int regionX = region.getRegionX();
        int regionY = region.getRegionY();

        File regionDir = new File(outputDir, String.format("%d.%d", regionX, regionY));
        if (!regionDir.exists()) {
            boolean created = regionDir.mkdirs();

            if (!created) {
                throw new IOException("Failed to create directory " + regionDir);
            }
        }

        String fileName = String.format("%d.%d.region.png", regionX, regionY);
        ImageIO.write(regionImage, "png", new File(regionDir, fileName));
    }

}
