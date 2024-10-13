package net.minecountry.world.io.mca.deserializer;

import net.minecountry.world.api.config.ChunkConfig;
import net.minecountry.world.api.config.WorldConfig;
import net.minecountry.world.api.model.Block;
import net.minecountry.world.api.model.Chunk;
import net.minecountry.world.api.model.LayeredBlock;
import net.minecountry.world.api.registries.BlockType;
import net.minecountry.world.io.mca.common.BlockFilter;
import net.minecountry.world.io.mca.common.BlockLayerFilter;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChunkDeserializer {
    private final short sectionMinY = -4;
    private final BlockFilter blockFilter;
    private final BlockLayerFilter blockLayerFilter;

    public ChunkDeserializer(BlockFilter blockFilter, BlockLayerFilter blockLayerFilter) {
        this.blockFilter = blockFilter;
        this.blockLayerFilter = blockLayerFilter;
    }

    public Optional<Chunk> deserialize(CompoundTag chunkTag) {
        int version = chunkTag.getInt("DataVersion");

        // https://minecraft.wiki/w/Data_version#List_of_data_versions
        if (version < 2844) // older than 1.18 (21w43a)
            throw new RuntimeException("Unhandled chunk version: " + version);

        if (!chunkTag.getString("Status").endsWith("full")) {
            return Optional.empty();
        }

        ListTag<CompoundTag> sectionsTags = chunkTag.getListTag("sections").asCompoundTagList();
        SectionDeserializer[] sections = deserializeSections(sectionsTags);

        short maxHeight = WorldConfig.MAX_HEIGHT;
        short minHeight = WorldConfig.MIN_HEIGHT;
        int chunkX = chunkTag.getInt("xPos");
        int chunkY = chunkTag.getInt("zPos");

        Chunk chunk = new Chunk(chunkX, chunkY);

        int startBlockX = chunkX * ChunkConfig.BLOCKS_SIDE;
        int startBlockY = chunkY * ChunkConfig.BLOCKS_SIDE;

        for (int index = 0; index < ChunkConfig.BLOCKS_COUNT; index++) {
            int localX = index % ChunkConfig.BLOCKS_SIDE;
            int localY = index / ChunkConfig.BLOCKS_SIDE;
            int globalX = startBlockX + localX;
            int globalY = startBlockY + localY;

            List<Short> layersHeight = new ArrayList<>();
            List<Short> layersTypes = new ArrayList<>();

            for (short height = maxHeight; height > minHeight; height--) {
                int sectionIndex = Math.floorDiv(height, ChunkConfig.SECTIONS_COUNT) - sectionMinY;

                if (sections[sectionIndex] == null)
                    continue;

                SectionDeserializer SectionDeserializer = sections[sectionIndex];
                BlockType blockType = SectionDeserializer.getBlockType(localX, height, localY);

                if (blockFilter.shouldIgnore(blockType))
                    continue;

                short blockTypeId = blockType.getId();

                if (layersTypes.contains(blockTypeId))
                    continue;

                Optional<BlockType> layerType = blockLayerFilter.shouldAddToLayer(blockType);
                if (layerType.isPresent()) {
                    layersHeight.add(height);
                    layersTypes.add(layerType.get().getId());
                    continue;
                }

                if (layersTypes.isEmpty()) {
                    chunk.setBlock(index, new Block(globalX, globalY, height, blockTypeId));
                } else {
                    short[] layersHeightArray = new short[layersTypes.size()];
                    short[] layersTypesArray = new short[layersTypes.size()];

                    for (int i = 0; i < layersTypes.size(); i++) {
                        layersHeightArray[i] = layersHeight.get(i);
                        layersTypesArray[i] = layersTypes.get(i);
                    }

                    chunk.setBlock(index, new LayeredBlock(globalX, globalY, height, blockTypeId, layersHeightArray, layersTypesArray));
                }

                break;
            }
        }

        return Optional.of(chunk);
    }

    private SectionDeserializer[] deserializeSections(ListTag<CompoundTag> sectionsTags) {
        SectionDeserializer[] sections = new SectionDeserializer[sectionsTags.size()];

        for (int i = 0; i < sections.length; i++) {
            CompoundTag sectionTag = sectionsTags.get(i);

            if (!sectionTag.getCompoundTag("block_states").containsKey("data"))
                continue;

            SectionDeserializer SectionDeserializer = new SectionDeserializer(sectionTag);
            sections[SectionDeserializer.getSectionY() - sectionMinY] = SectionDeserializer;
        }

        return sections;
    }
}
