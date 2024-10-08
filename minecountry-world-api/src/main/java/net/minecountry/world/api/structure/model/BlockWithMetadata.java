package net.minecountry.world.api.structure.model;

import net.minecountry.world.api.structure.model.metadata.BlockMeta;
import net.minecountry.world.api.structure.registries.BlockType;

import java.util.Map;

public class BlockWithMetadata extends Block {
    private final Map<Class<? extends BlockMeta>, BlockMeta> metadata;

    public BlockWithMetadata(int x, int y, short height, short blockType,
                             Map<Class<? extends BlockMeta>, BlockMeta> metadata) {
        super(x, y, height, blockType);
        this.metadata = metadata;
    }

    public Map<Class<? extends BlockMeta>, BlockMeta> getMetadata() {
        return metadata;
    }
}
