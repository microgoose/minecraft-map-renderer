package net.world.map.generator.renderer;

import net.world.map.generator.config.RenderConfig;
import net.world.map.generator.util.ArrayGraphics;
import net.world.map.structure.config.ChunkConfig;
import net.world.map.structure.config.RegionConfig;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.Region;
import net.world.map.structure.model.World;

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
