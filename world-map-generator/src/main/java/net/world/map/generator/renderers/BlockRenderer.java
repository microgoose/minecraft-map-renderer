package net.world.map.generator.renderers;

import net.world.map.generator.config.RenderConfig;
import net.world.map.generator.util.ArrayGraphics;
import net.world.map.structure.collecions.BlockType;
import net.world.map.structure.collecions.MaterialColorCollection;
import net.world.map.structure.collecions.PlantBlockCollection;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.BlockWithMetadata;
import net.world.map.structure.model.metadata.BlockMeta;
import net.world.map.structure.model.metadata.PlantMeta;
import net.world.map.structure.model.metadata.UnderwaterMeta;
import net.world.map.structure.util.Colors;

import java.util.Map;

public class BlockRenderer {
    private final int localX;
    private final int localY;
    private final double height;
    private final double prevHeight;
    private final int baseColor;

    private Map<Class<? extends BlockMeta>, BlockMeta> metadata;

    public BlockRenderer(int localX, int localY, double prevHeight, Block block) {
        this.localX = localX;
        this.localY = localY;
        this.height = block.getHeight();
        this.prevHeight = prevHeight;
        this.baseColor = MaterialColorCollection.getColor(block.getBlockType());

        if (block instanceof BlockWithMetadata blockWithMetadata) {
            metadata = blockWithMetadata.getMetadata();
        }
    }

    public int[] render() {
        int[] pixels = new int[RenderConfig.RENDER_SCALE];
        int color = baseColor;

        if (metadata == null) {
            color = modifyColorByHeight(color);
        } else {
            color = modifyColorByMetadata(color);
        }

        int blockHeight = RenderConfig.RENDER_SCALE;
        int blockWidth = RenderConfig.RENDER_SCALE;
        ArrayGraphics.fillRect(0, 0, blockWidth, blockHeight, pixels, color, blockWidth);

        return pixels;
    }

    private int modifyColorByHeight(int color) {
        int brightness;
        double heightDiff = (height - prevHeight) * 4.0D / (double) (1 + 4) + ((double) (localX + localY & 1) - 0.5D) * 0.4D;

        if (heightDiff > 0.6D) {
            brightness = 0;
        } else if (heightDiff < -0.6D) {
            brightness = 68;
        } else {
            brightness = 34;
        }

        return Colors.blend(brightness << 24, Colors.setAlpha(255, color));
    }

    private int modifyColorByMetadata(int color) {
        if (metadata.containsKey(PlantMeta.class)) {
            PlantMeta meta = (PlantMeta) metadata.get(PlantMeta.class);

            if (!PlantBlockCollection.isGrassPlant(meta.getPlantType())) {
                color = MaterialColorCollection.getColor(meta.getPlantType());
            }
        }

        if (metadata.containsKey(UnderwaterMeta.class)) {
            int brightness;

            UnderwaterMeta meta = (UnderwaterMeta) metadata.get(UnderwaterMeta.class);
            short depth = meta.getDepth();
            double heightDiff = (double) depth * 0.1D + (double) (localX + localY & 1) * 0.2D;
            color = MaterialColorCollection.getColor(BlockType.WATER);

            if (heightDiff < 0.5D) {
                brightness = 0x00;
            } else if (heightDiff > 0.9D) {
                brightness = 0x44;
            } else {
                brightness = 0x22;
            }

            return Colors.blend(brightness << 24, Colors.setAlpha(255, color));
        }

        return modifyColorByHeight(color);
    }
}
