package net.world.map.loader.parser;

import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;
import net.world.map.loader.config.LoadingBlockConfig;
import net.world.map.structure.collection.BlockType;
import net.world.map.structure.collection.PlantBlockCollection;
import net.world.map.structure.config.ChunkConfig;
import net.world.map.structure.config.SectionConfig;
import net.world.map.structure.config.WorldConfig;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.BlockWithMetadata;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.metadata.BlockMeta;
import net.world.map.structure.model.metadata.PlantMeta;
import net.world.map.structure.model.metadata.UnderwaterMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChunkParser {
    private static final short sectionMinY = -4;

    public static Optional<Chunk> parse(CompoundTag chunkTag) {
        int version = chunkTag.getInt("DataVersion");

        // https://minecraft.wiki/w/Data_version#List_of_data_versions
        if (version < 2844) // older than 1.18 (21w43a)
            throw new RuntimeException("Unhandled chunk version: " + version);

        if (!chunkTag.getString("Status").endsWith("full")) {
            return Optional.empty();
        }

        ListTag<CompoundTag> sectionsTags = chunkTag.getListTag("sections").asCompoundTagList();
        SectionParser[] sections = parseSections(sectionsTags);

        short maxHeight = WorldConfig.MAX_HEIGHT;
        short minHeight = WorldConfig.MIN_HEIGHT;
        int chunkX = chunkTag.getInt("xPos");
        int chunkY = chunkTag.getInt("zPos");

        Chunk chunk = new Chunk(chunkX, chunkY);

        int startBlockX = chunkX * ChunkConfig.CHUNK_SIZE;
        int startBlockY = chunkY * ChunkConfig.CHUNK_SIZE;

        for (int x = 0; x < ChunkConfig.CHUNK_SIZE; x++) {
            for (int y = 0; y < ChunkConfig.CHUNK_SIZE; y++) {
                Map<Class<? extends BlockMeta>, BlockMeta> metadata = new HashMap<>();

                for (short height = maxHeight; height > minHeight; height--) {
                    int sectionIndex = Math.floorDiv(height, SectionConfig.SECTION_HEIGHT) - sectionMinY;

                    if (sections[sectionIndex] == null)
                        continue;

                    SectionParser sectionParser = sections[sectionIndex];
                    BlockType blockType = sectionParser.getBlockType(x, height, y);

                    if (LoadingBlockConfig.IGNORED_BLOCKS.contains(blockType))
                        continue;

                    if (blockType.equals(BlockType.WATER) || PlantBlockCollection.isWaterPlant(blockType)) {
                        UnderwaterMeta meta = (UnderwaterMeta) metadata.get(UnderwaterMeta.class);

                        if (meta == null)
                            metadata.put(UnderwaterMeta.class, new UnderwaterMeta());
                        else
                            meta.incrementDepth();

                        continue;
                    }

                    if (PlantBlockCollection.isPlant(blockType)) {
                        PlantMeta meta = (PlantMeta) metadata.get(PlantMeta.class);

                        if (meta == null)
                            metadata.put(PlantMeta.class, new PlantMeta(blockType));
                        else
                            meta.increasePlantHeight();

                        continue;
                    }

                    int blockGlobalX = startBlockX + x;
                    int blockGlobalY = startBlockY + y;

                    if (metadata.isEmpty()) {
                        chunk.addBlockByLocal(x, y, new Block(blockGlobalX, blockGlobalY, height, blockType));
                    } else {
                        chunk.addBlockByLocal(x, y,
                                new BlockWithMetadata(blockGlobalX, blockGlobalY, height, blockType, metadata));
                    }

                    break;
                }
            }
        }

        return Optional.of(chunk);
    }

    private static SectionParser[] parseSections(ListTag<CompoundTag> sectionsTags) {
        SectionParser[] sections = new SectionParser[sectionsTags.size()];

        for (int i = 0; i < sections.length; i++) {
            CompoundTag sectionTag = sectionsTags.get(i);

            if (!sectionTag.getCompoundTag("block_states").containsKey("data"))
                continue;

            SectionParser sectionParser = new SectionParser(sectionTag);
            sections[sectionParser.getSectionY() - sectionMinY] = sectionParser;
        }

        return sections;
    }
}
