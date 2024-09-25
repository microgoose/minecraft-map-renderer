package net.world.map.generator.util;

public class ArrayGraphics {
    public static void fillRect(int startX, int startY, int width, int height,
                                int[] pixels, int color, int imageWidth) {
        for (int y = 0; y < width ; y++) {
            for (int x = 0; x < height; x++) {
                int pixelX = startX + x;
                int pixelY = startY + y;
                int index = pixelY * imageWidth + pixelX;

                if (index >= 0 && index < pixels.length) {
                    pixels[index] = color;
                }
            }
        }
    }

    public static void fillRect(int startX, int startY, int width, int height,
                                int[] pixels, int[] colors, int imageWidth) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixelX = startX + x;
                int pixelY = startY + y;
                int index = pixelY * imageWidth + pixelX;

                if (index >= 0 && index < pixels.length) {
                    int colorIndex = x % colors.length;
                    pixels[index] = colors[colorIndex];
                }
            }
        }
    }
}
