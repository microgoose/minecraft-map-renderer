package net.minecraft.map.converter;

import net.minecraft.map.converter.utils.MCAMath;
import net.minecraft.map.core.registries.BlockType;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;

import java.util.Arrays;

public class SectionReader {
    private static final String prefix = "minecraft:";
    private static final int prefixLength = prefix.length();
    private final int sectionY;
    private final BlockType[] blockPalette;
    private long[] blocks;
    private final int bitsPerBlock;

    public SectionReader(CompoundTag sectionTag) {
        CompoundTag blockStatesTag = sectionTag.getCompoundTag("block_states");
        ListTag<CompoundTag> paletteTag = blockStatesTag.getListTag("palette").asCompoundTagList();
        this.sectionY = sectionTag.getByte("Y");
        this.blockPalette = new BlockType[paletteTag.size()];

        for (int i = 0; i < this.blockPalette.length; i++) {
            CompoundTag entry = paletteTag.get(i);
            String id = entry.getString("Name");
            this.blockPalette[i] = BlockType.getByName(id.substring(prefixLength).toUpperCase());
        }

        this.blocks = blockStatesTag.getLongArray("data");
        this.bitsPerBlock = this.blocks.length / 64;

        if (this.blocks.length < 256 && this.blocks.length > 0) {
            this.blocks = Arrays.copyOf(this.blocks, 256);
        }
    }

    public int getSectionY() {
        return sectionY;
    }

    public BlockType getBlockType(int x, int y, int z) {
        if (blockPalette.length == 1) {
            return blockPalette[0];
        }

        if (blocks.length == 0) {
            return BlockType.AIR;
        }

        int blockIndex = ((y & 0xF) << 8) + ((z & 0xF) << 4) + (x & 0xF);
        long value = MCAMath.getValueFromLongArray(blocks, blockIndex, bitsPerBlock);

        if (value >= blockPalette.length) {
            return BlockType.AIR;
        }

        return blockPalette[(int) value];
    }
}
