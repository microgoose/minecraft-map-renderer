package net.minecountry.world.io.dat.model;

import java.util.List;

public class CompressedChunk {
    public static final long serialVersionUID = 1L;

    public final short[] palette;
    public final byte[] blockTypes;
    public final short[] blockHeights;

    public final byte[] layersPresenceBitmap; //256 bit
    public final short[][] layersBlockTypes;
    public final short[][] layersHeights;

    public CompressedChunk(short[] palette, byte[] blockTypes, short[] blockHeights,
                           byte[] layersPresenceBitmap, short[][] layersBlockTypes, short[][] layersHeights) {
        this.palette = palette;
        this.blockTypes = blockTypes;
        this.blockHeights = blockHeights;
        this.layersPresenceBitmap = layersPresenceBitmap;
        this.layersBlockTypes = layersBlockTypes;
        this.layersHeights = layersHeights;
    }

    public CompressedChunk(List<Short> palette, byte[] blockTypes, short[] blockHeights, byte[] layersPresenceBitmap,
                           List<short[]> layeredBlockTypes, List<short[]> layeredBlockHeights) {
        this.blockTypes = blockTypes;
        this.blockHeights = blockHeights;
        this.layersPresenceBitmap = layersPresenceBitmap;

        this.palette = new short[palette.size()];
        for (int i = 0; i < palette.size(); i++) {
            this.palette[i] = palette.get(i);
        }

        this.layersBlockTypes = new short[layeredBlockTypes.size()][];
        for (int i = 0; i < layeredBlockTypes.size(); i++) {
            this.layersBlockTypes[i] = layeredBlockTypes.get(i);
        }

        this.layersHeights = new short[layeredBlockHeights.size()][];
        for (int i = 0; i < layeredBlockHeights.size(); i++) {
            this.layersHeights[i] = layeredBlockHeights.get(i);
        }
    }
}
