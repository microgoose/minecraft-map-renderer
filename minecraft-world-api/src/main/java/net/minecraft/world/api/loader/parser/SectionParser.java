package net.minecraft.world.api.loader.parser;

import net.minecraft.world.api.loader.utils.MCAMath;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;
import net.minecraft.world.api.structure.registries.BlockTypes;

import java.util.Arrays;

public class SectionParser {
    private static final String prefix = "minecraft:";
    private static final int prefixLength = prefix.length();
    private final int sectionY;
    private final BlockTypes[] blockPalette;
    private long[] blocks;
    private final int bitsPerBlock;

    public SectionParser(CompoundTag sectionTag) {
        CompoundTag blockStatesTag = sectionTag.getCompoundTag("block_states");
        ListTag<CompoundTag> paletteTag = blockStatesTag.getListTag("palette").asCompoundTagList();
        this.sectionY = sectionTag.getByte("Y");
        this.blockPalette = new BlockTypes[paletteTag.size()];

        for (int i = 0; i < this.blockPalette.length; i++) {
            CompoundTag entry = paletteTag.get(i);
            String id = entry.getString("Name");
            this.blockPalette[i] = BlockTypes.valueOf(id.substring(prefixLength).toUpperCase());
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

    public BlockTypes getBlockType(int x, int y, int z) {
        if (blockPalette.length == 1) {
            return blockPalette[0];
        }

        if (blocks.length == 0) {
            return BlockTypes.AIR;
        }

        int blockIndex = ((y & 0xF) << 8) + ((z & 0xF) << 4) + (x & 0xF);
        long value = MCAMath.getValueFromLongArray(blocks, blockIndex, bitsPerBlock);

        if (value >= blockPalette.length) {
            return BlockTypes.AIR;
        }

        return blockPalette[(int) value];
    }
}
