package net.minecraft.world.api.renderer;

import net.minecraft.world.api.renderer.utils.ArrayGraphics;
import net.minecraft.world.api.renderer.config.RenderConfig;
import net.minecraft.world.api.structure.config.ChunkConfig;
import net.minecraft.world.api.structure.config.RegionConfig;
import net.minecraft.world.api.structure.model.Chunk;
import net.minecraft.world.api.structure.model.Region;
import net.minecraft.world.api.structure.model.World;

import java.awt.image.BufferedImage;
import java.util.Map;

public class RegionRenderer {
    public static BufferedImage render(World world, Region region) {
        int chunkWidth = ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;
        int chunkHeight = ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;
        int imageWidth = RegionConfig.REGION_SIZE * chunkWidth;
        int imageHeight = RegionConfig.REGION_SIZE * chunkHeight;
        int[] pixels = new int[imageHeight * imageWidth];

        for (Map.Entry<Integer, Chunk> entry : region.getChunks().entrySet()) {
            Chunk chunk = entry.getValue();

            int[] chunkPixels = ChunkRenderer.render(world, chunk);
            int chunkLocalX = Math.floorDiv(entry.getKey(), RegionConfig.REGION_SIZE);
            int chunkLocalY = Math.floorMod(entry.getKey(), RegionConfig.REGION_SIZE);
            int startX = chunkLocalX * chunkWidth;
            int startY = chunkLocalY * chunkHeight;

            ArrayGraphics.fillRect(startX, startY, chunkWidth, chunkHeight, pixels, chunkPixels, imageWidth);
        }

        BufferedImage regionImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        regionImage.setRGB(0, 0, imageWidth, imageHeight, pixels, 0, imageWidth);

        return regionImage;
    }
}
