package net.minecountry.world.io.dat.convertor;

import net.minecountry.world.io.dat.model.CompressedChunk;
import net.minecountry.world.io.dat.model.CompressedRegion;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class RegionConvertor {
    public static byte[] toByteArray(CompressedRegion region) throws IOException {
        try (ByteArrayOutputStream bs = new ByteArrayOutputStream()) {
            for (Map.Entry<Short, CompressedChunk> entry : region.getChunks().entrySet()) {
                bs.write(entry.getKey());
                bs.write(ChunkConvertor.toByteArray(entry.getValue()));
            }

            return bs.toByteArray();
        }
    }
}
