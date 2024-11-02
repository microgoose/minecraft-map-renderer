package net.mca.to.dat.converter;

import net.minecountry.world.api.config.RegionConfig;
import net.querz.mca.CompressionType;
import net.querz.nbt.io.NBTInputStream;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.Tag;

import java.io.*;
import java.nio.file.Path;

public class RegionConverter extends Thread {
    public static void convert(File regionFile, Path destinationFolder) throws IOException {
        String[] parts = regionFile.getName().split("\\.");
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);

        Path outputPath = destinationFolder.resolve(String.format("%s.%s.dat", x, y));
        File outputFile = outputPath.toFile();

        try (RandomAccessFile raf = new RandomAccessFile(regionFile, "r");
             ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(baos)) {

            for (short index = 0; index < RegionConfig.CHUNKS_COUNT; index++) {
                dos.writeShort(index);
                deserializeChunk(raf, index, dos);
            }

            byte[] byteArray = baos.toByteArray();
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(byteArray);
            }
        }
    }

    private static void deserializeChunk(RandomAccessFile raf, int index, DataOutputStream dos) throws IOException {
        raf.seek(index * 4L);
        int offset = raf.read() << 16;
        offset |= (raf.read() & 0xFF) << 8;
        offset |= raf.read() & 0xFF;

        if (raf.readByte() == 0)
            return;

        raf.seek(4096L * offset + 4); // +4 skip chunk size

        byte compressionTypeByte = raf.readByte();
        CompressionType compressionType = CompressionType.getFromID(compressionTypeByte);

        if (compressionType == null)
            throw new IOException("Invalid compression type " + compressionTypeByte);

        DataInputStream dis = new DataInputStream(new BufferedInputStream(
            compressionType.decompress(new FileInputStream(raf.getFD()))
        ));

        NamedTag tag = new NBTInputStream(dis).readTag(Tag.DEFAULT_MAX_DEPTH);

        if (tag != null && tag.getTag() instanceof CompoundTag chunkTag)
            ChunkConverter.convert(chunkTag, dos);
        else
            throw new IOException("Invalid data tag: " + (tag == null ? "null" : tag.getName()));
    }
}