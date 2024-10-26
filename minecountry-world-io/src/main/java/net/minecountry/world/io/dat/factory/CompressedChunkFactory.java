package net.minecountry.world.io.dat.factory;

import net.minecountry.world.api.config.ChunkConfig;
import net.minecountry.world.api.model.Block;
import net.minecountry.world.api.model.Chunk;
import net.minecountry.world.api.model.LayeredBlock;
import net.minecountry.world.io.dat.model.CompressedChunk;

import java.util.ArrayList;
import java.util.List;

public class CompressedChunkFactory {
    public static CompressedChunk build(Chunk chunk) {
        Block[] blocks = chunk.getBlocks();

        List<Short> palette = new ArrayList<>();
        byte[] blockTypes = new byte[ChunkConfig.BLOCKS_COUNT]; //256
        short[] blockHeights = new short[ChunkConfig.BLOCKS_COUNT];

        byte[] presenceBitmap = new byte[32]; //256 bit
        List<short[]> layeredBlockTypes = new ArrayList<>();
        List<short[]> layeredBlockHeights = new ArrayList<>();

        for (int coordinate = 0; coordinate < ChunkConfig.BLOCKS_COUNT; coordinate++) {
            Block block = blocks[coordinate];
            short type = block.getBlockType();
            short height = block.getHeight();
            byte paletteIndex = (byte) palette.indexOf(type);

            if (paletteIndex == -1) {
                paletteIndex = (byte) palette.size();
                palette.add(type);
            }

            blockTypes[coordinate] = paletteIndex;
            blockHeights[coordinate] = height;

            if (block instanceof LayeredBlock layeredBlock) {
                byte byteIndex = (byte) (coordinate / 8);
                byte bitIndex = (byte) (coordinate % 8);
                presenceBitmap[byteIndex] |= (byte) (1 << bitIndex);
                layeredBlockTypes.add(layeredBlock.getHeights());
                layeredBlockHeights.add(layeredBlock.getTypes());
            }
        }

        byte bitsPerByte = (byte) palette.size();
        int bitPosition = 0;
        byte[] paletteIndexes = new byte[(bitsPerByte * ChunkConfig.BLOCKS_COUNT) / 8 ];

        for (int index = 0; index < ChunkConfig.BLOCKS_COUNT; index++) {
            short type = blockTypes[index];
            byte paletteIndex = (byte) palette.indexOf(type);

            for (int i = bitsPerByte - 1; i > -1; i--) {
                boolean bit = (paletteIndex & (1 << i)) != 0;

                if (bit)
                    paletteIndexes[bitPosition / 8] |= (byte) (1 << (7 - (bitPosition % 8)));

                bitPosition++;
            }
        }

        return new CompressedChunk(
            palette, paletteIndexes, blockHeights, presenceBitmap,
            layeredBlockTypes, layeredBlockHeights
        );
    }
}
