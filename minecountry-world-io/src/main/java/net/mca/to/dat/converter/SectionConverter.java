package net.mca.to.dat.converter;

import net.minecountry.world.api.registries.BlockType;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class SectionConverter {
    private static final String prefix = "minecraft:";
    private static final int prefixLength = prefix.length();

    public static void convert(CompoundTag sectionTag, DataOutputStream dos) throws IOException {
        CompoundTag blockStatesTag = sectionTag.getCompoundTag("block_states");
        ListTag<CompoundTag> paletteTag = blockStatesTag.getListTag("palette").asCompoundTagList();

        int paletteSize = paletteTag.size();
        long[] paletteBlocks = blockStatesTag.getLongArray("data");
        byte sectionY = sectionTag.getByte("Y");

        ByteBuffer byteBuffer = ByteBuffer.allocate(
            paletteSize * Short.BYTES +
            paletteBlocks.length * Long.BYTES +
            Byte.BYTES
        );

        byteBuffer.put(sectionY);

        for (long paletteBlock : paletteBlocks) {
            byteBuffer.putLong(paletteBlock);
        }

        for (int i = 0; i < paletteTag.size(); i++) {
            CompoundTag entry = paletteTag.get(i);
            String name = entry.getString("Name");
            short id = BlockType.getByName(name.substring(prefixLength).toUpperCase()).getId();
            byteBuffer.putShort(id);
        }

        dos.write(byteBuffer.array());
    }
}
