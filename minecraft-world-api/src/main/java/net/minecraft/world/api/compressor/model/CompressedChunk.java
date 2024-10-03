package net.minecraft.world.api.compressor.model;

public class CompressedChunk {
    private final short[] blockLayer = new short[256];
    private final short[] blockHeights = new short[256];

    private final byte[] waterLayer = new byte[32];
    private final short[] waterDepth = new short[256];

    private final short[] plantLayer = new short[256];
    private final short[] plantHeight = new short[256];

    public void setBlockLayer(int index, short type, short height) {
        blockLayer[index] = type;
        blockHeights[index] = height;
    }

    public void setWaterLayer(int index, short depth) {
        waterDepth[index] = depth;
        setToBitMap(waterLayer, index);
    }

    public void setPlantLayer(int index, short type, short height) {
        plantLayer[index] = type;
        plantHeight[index] = height;
    }

    private void setToBitMap(byte[] bitMap, int index) {
        int byteIndex = index / 8;
        int bitIndex = byteIndex % 8;
        bitMap[byteIndex] |= (1 << bitIndex);
    }
}
