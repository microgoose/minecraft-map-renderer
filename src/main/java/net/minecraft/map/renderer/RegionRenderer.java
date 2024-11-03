package net.minecraft.map.renderer;

import net.minecraft.map.core.config.ChunkConfig;
import net.minecraft.map.core.config.RegionConfig;
import net.minecraft.map.core.locators.ChunkLocator;
import net.minecraft.map.core.model.Chunk;
import net.minecraft.map.core.model.Region;
import net.minecraft.map.core.model.World;
import net.minecraft.map.renderer.config.RenderConfig;
import net.minecraft.map.renderer.utils.ArrayGraphics;

import java.awt.image.BufferedImage;

public class RegionRenderer {
    public static BufferedImage render(World world, Region region) {
        int chunkSide = ChunkConfig.BLOCKS_SIDE * RenderConfig.RENDER_SCALE;
        int imageSide = RegionConfig.CHUNK_SIDE * chunkSide;
        int[] pixels = new int[imageSide * imageSide];

        for (int x = 0; x < RegionConfig.CHUNK_SIDE; x++) {
            for (int y = 0; y < RegionConfig.CHUNK_SIDE; y++) {
                Chunk chunk = ChunkLocator.getAtLocal(region, x, y);

                if (chunk == null)
                    continue;

                ArrayGraphics.fillRect(x * chunkSide, y * chunkSide, chunkSide, chunkSide,
                        pixels, ChunkRenderer.render(world, chunk), imageSide);
            }
        }

        BufferedImage regionImage = new BufferedImage(imageSide, imageSide, BufferedImage.TYPE_INT_ARGB);
        regionImage.setRGB(0, 0, imageSide, imageSide, pixels, 0, imageSide);

        return regionImage;
    }
}
