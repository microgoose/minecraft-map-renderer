package net.minecountry.world.io;

import net.mca.to.dat.converter.RegionConverter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MCAToDatTest {
    public static final Path REGION_PATH = Path.of("minecountry-world-io/src/test/resources/regions");
    public static final Path DESTINATION_PATH = Path.of("minecountry-world-io/src/test/resources/converted");

    public static void main(String[] args) {
        File regDir = REGION_PATH.toFile();

        if (!regDir.exists())
            throw new IllegalArgumentException("Region directory does not exist: " + regDir);
        if (!regDir.isDirectory())
            throw new IllegalArgumentException("Region directory is not a directory: " + regDir);

        File[] regionFiles = regDir.listFiles();
        if (regionFiles == null)
            throw new IllegalArgumentException("Region directory contains no region files: " + regDir);

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<String> errors = new ArrayList<>();

        for (File regionFile : regionFiles) {
            executorService.submit(() -> {
                try {
                    RegionConverter.convert(regionFile, DESTINATION_PATH);
                } catch (IOException e) {
                    errors.add(e.getMessage());
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(regionFiles.length, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        if (errors.isEmpty()) {
            System.out.println("Converted " + REGION_PATH + " to " + DESTINATION_PATH);
        } else {
            System.out.println("Converted with errors: "+ errors);
        }
    }
}
