package net.minecountry.world.io.dat.convertor;

import net.minecountry.world.io.dat.model.CompressedChunk;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ChunkConvertor {
    public static byte[] toByteArray(CompressedChunk chunk) throws IOException {
        try (ByteArrayOutputStream bs = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(bs)) {

            dos.writeShort(chunk.palette.length);
            for (short i = 0; i < chunk.palette.length; i++) {
                dos.writeByte(chunk.palette[i]);
            }

            dos.writeShort(chunk.blockTypes.length);
            for (short i = 0; i < chunk.blockTypes.length; i++) {
                dos.writeByte(chunk.blockTypes[i]);
            }

            dos.writeShort(chunk.blockHeights.length);
            for (short i = 0; i < chunk.blockHeights.length; i++) {
                dos.writeByte(chunk.blockHeights[i]);
            }

            dos.writeByte(chunk.layersPresenceBitmap.length);
            for (short i = 0; i < chunk.layersPresenceBitmap.length; i++) {
                dos.writeByte(chunk.layersPresenceBitmap[i]);
            }

            dos.writeByte(chunk.layersBlockTypes.length);
            for (short i = 0; i < chunk.layersBlockTypes.length; i++) {
                short[] layerBlockTypes = chunk.layersBlockTypes[i];

                dos.writeByte(layerBlockTypes.length);
                for (short j = 0; j < layerBlockTypes.length; j++) {
                    dos.writeByte(layerBlockTypes[j]);
                }
            }

            dos.writeByte(chunk.layersHeights.length);
            for (short i = 0; i < chunk.layersHeights.length; i++) {
                short[] layerHeights = chunk.layersHeights[i];

                dos.writeByte(layerHeights.length);
                for (short j = 0; j < layerHeights.length; j++) {
                    dos.writeByte(layerHeights[j]);
                }
            }

            return bs.toByteArray();
        }
    }
}
