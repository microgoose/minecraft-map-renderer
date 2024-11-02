package net.mca.to.dat.converter;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;

import java.io.DataOutputStream;
import java.io.IOException;

public class ChunkConverter {
    public static void convert(CompoundTag chunkTag, DataOutputStream dos) throws IOException {
        int version = chunkTag.getInt("DataVersion");

        // https://minecraft.wiki/w/Data_version#List_of_data_versions
        if (version < 2844) // older than 1.18 (21w43a)
            throw new RuntimeException("Unhandled chunk version: " + version);
        if (!chunkTag.getString("Status").endsWith("full"))
            return;

        ListTag<CompoundTag> sectionsTags = chunkTag.getListTag("sections").asCompoundTagList();
        for (int i = 0; i < sectionsTags.size(); i++) {
            CompoundTag sectionTag = sectionsTags.get(i);

            if (!sectionTag.getCompoundTag("block_states").containsKey("data"))
                continue;

            SectionConverter.convert(sectionTag, dos);
        }
    }
}
