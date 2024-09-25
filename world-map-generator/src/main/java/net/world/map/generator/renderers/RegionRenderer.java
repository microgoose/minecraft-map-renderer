package net.world.map.generator.renderers;

import net.world.map.generator.config.RenderConfig;
import net.world.map.structure.config.ChunkConfig;
import net.world.map.structure.config.RegionConfig;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.Region;
import net.world.map.structure.model.World;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

public class RegionRenderer {
    public static BufferedImage render(World world, Region region) {
        BufferedImage regionMapImage = new BufferedImage(
            RegionConfig.REGION_AREA * RenderConfig.RENDER_SCALE,
            RegionConfig.REGION_AREA * RenderConfig.RENDER_SCALE,
            BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D graphics = regionMapImage.createGraphics();

        graphics.setColor(Color.RED);

        for (Map.Entry<Integer, Chunk> entry : region.getChunks().entrySet()) {
            Chunk chunk = entry.getValue();
            BufferedImage chunkMapImage = ChunkRenderer.render(world, chunk);

            int chunkLocalX = Math.floorDiv(entry.getKey(), RegionConfig.REGION_SIZE);
            int chunkLocalY = Math.floorMod(entry.getKey(), RegionConfig.REGION_SIZE);
            int xPos = chunkLocalX * ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;
            int yPos = chunkLocalY * ChunkConfig.CHUNK_SIZE * RenderConfig.RENDER_SCALE;

            graphics.drawImage(chunkMapImage, xPos, yPos, null);
//            graphics.drawRect(xPos, yPos, ChunkConfig.CHUNK_SIZE, ChunkConfig.CHUNK_SIZE);
        }

        graphics.dispose();

        return regionMapImage;
    }
}
