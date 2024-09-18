package net.world.map.loader.parsers;

import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;
import net.world.map.loader.util.MCAMath;
import net.world.map.structure.config.BlockMaterials;

import java.util.Arrays;

public class SectionParser {
    private final int sectionY;
    private final String[] blockPalette;
    private long[] blocks;
    private final int bitsPerBlock;

    public SectionParser(CompoundTag sectionTag) {
        CompoundTag blockStatesTag = sectionTag.getCompoundTag("block_states");
        ListTag<CompoundTag> paletteTag = blockStatesTag.getListTag("palette").asCompoundTagList();
        this.sectionY = sectionTag.getByte("Y");
        this.blockPalette = new String[paletteTag.size()];

        for (int i = 0; i < this.blockPalette.length; i++) {
            CompoundTag entry = paletteTag.get(i);
            String id = entry.getString("Name");
            this.blockPalette[i] = id.replaceAll("minecraft:", "");
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

    public String getBlockType(int x, int y, int z) {
        if (blockPalette.length == 1) {
            return blockPalette[0];
        }

        if (blocks.length == 0) {
            return BlockMaterials.AIR;
        }

        int blockIndex = ((y & 0xF) << 8) + ((z & 0xF) << 4) + (x & 0xF);
        long value = MCAMath.getValueFromLongArray(blocks, blockIndex, bitsPerBlock);

        if (value >= blockPalette.length) {
            return BlockMaterials.AIR;
        }

        return blockPalette[(int) value];
    }
}
