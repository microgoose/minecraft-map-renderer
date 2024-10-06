package net.minecountry.renderer;

import net.minecountry.renderer.config.RenderConfig;
import net.minecountry.renderer.utils.ArrayGraphics;
import net.minecountry.world.api.structure.config.ChunkConfig;
import net.minecountry.world.api.structure.config.RegionConfig;
import net.minecountry.world.api.structure.model.Chunk;
import net.minecountry.world.api.structure.model.Region;
import net.minecountry.world.api.structure.model.World;
import net.minecountry.world.api.structure.service.ChunkService;

import java.awt.image.BufferedImage;

public class RegionRenderer {
    public static BufferedImage render(World world, Region region) {
        int chunkSide = ChunkConfig.BLOCKS_SIDE * RenderConfig.RENDER_SCALE;
        int imageSide = RegionConfig.CHUNK_SIDE * chunkSide;
        int[] pixels = new int[imageSide * imageSide];

        for (int x = 0; x < RegionConfig.CHUNK_SIDE; x++) {
            for (int y = 0; y < RegionConfig.CHUNK_SIDE; y++) {
                Chunk chunk = ChunkService.getAtLocal(region, x, y);

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
