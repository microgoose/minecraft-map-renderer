package net.world.map.loader.parsers;

import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.ListTag;
import net.world.map.loader.config.LoadingBlockConfig;
import net.world.map.structure.collecions.MaterialColorsCollection;
import net.world.map.structure.collecions.MaterialCollection;
import net.world.map.structure.config.*;
import net.world.map.structure.model.Block;
import net.world.map.structure.model.Chunk;
import net.world.map.structure.model.UnderwaterBlock;

import java.util.Optional;
import java.util.TreeMap;

public class ChunkParser {
    public static Optional<Chunk> parse(CompoundTag chunkTag) {
        int version = chunkTag.getInt("DataVersion");

        // https://minecraft.wiki/w/Data_version#List_of_data_versions
        if (version < 2844) // older than 1.18 (21w43a)
            throw new RuntimeException("Unhandled chunk version: " + version);

        if (!chunkTag.getString("Status").endsWith("full")) {
            return Optional.empty();
        }

        ListTag<CompoundTag> sectionsTags = chunkTag.getListTag("sections").asCompoundTagList();
        TreeMap<Integer, SectionParser> sections = new TreeMap<>();

        for (CompoundTag sectionTag : sectionsTags) {
            if (!sectionTag.getCompoundTag("block_states").containsKey("data"))
                continue;

            SectionParser sectionParser = new SectionParser(sectionTag);
            sections.put(sectionParser.getSectionY(), sectionParser);
        }

        int maxHeight = WorldConfig.MAX_HEIGHT;
        int minHeight = WorldConfig.MIN_HEIGHT;
        int chunkX = chunkTag.getInt("xPos");
        int chunkY = chunkTag.getInt("zPos");

        Chunk chunk = new Chunk(chunkX, chunkY);

        int startBlockX = chunkX * ChunkConfig.CHUNK_SIZE;
        int startBlockY = chunkY * ChunkConfig.CHUNK_SIZE;

        for (int x = 0; x < ChunkConfig.CHUNK_SIZE; x++) {
            for (int y = 0; y < ChunkConfig.CHUNK_SIZE; y++) {
                int depth = 0;

                for (int height = maxHeight; height > minHeight; height--) {
                    int sectionHeightPos = Math.floorDiv(height, SectionConfig.SECTION_HEIGHT);

                    if (!sections.containsKey(sectionHeightPos))
                        continue;

                    SectionParser sectionParser = sections.get(sectionHeightPos);
                    String blockType = sectionParser.getBlockType(x, height, y);

                    if (blockType.equals(MaterialCollection.WATER)) {
                        depth++;
                        continue;
                    }

                    if (LoadingBlockConfig.IGNORED_BLOCKS.contains(blockType))
                        continue;

                    int blockGlobalX = startBlockX + x;
                    int blockGlobalY = startBlockY + y;
                    int rgb = MaterialColorsCollection.getColor(blockType);

                    if (depth > 0) {
                        chunk.addBlockByLocal(x, y, new UnderwaterBlock(blockGlobalX, blockGlobalY, height, depth, rgb));
                        break;
                    }

                    chunk.addBlockByLocal(x, y, new Block(blockGlobalX, blockGlobalY, height, rgb));
                    break;
                }
            }
        }

        return Optional.of(chunk);
    }
}
