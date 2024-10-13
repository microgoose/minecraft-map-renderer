package net.minecountry.world.io;

import java.nio.file.Path;

public class MCAToDatTest {
    public static final Path REGION_PATH = Path.of("minecountry-world-io/src/test/resources/regions");
    public static final Path DESTINATION_PATH = Path.of("minecountry-world-io/src/test/resources/converted");

    public static void main(String[] args) {
        //TODO
        System.out.println("Converted " + REGION_PATH + " to " + DESTINATION_PATH);
    }

    private static Path getDir(Path dirPath) {
        if (!dirPath.toFile().exists())
            throw new IllegalArgumentException("Directory does not exist: " + dirPath);
        if (dirPath.toFile().isFile())
            throw new IllegalArgumentException("Directory is a file: " + dirPath);

        return dirPath;
    }
}
