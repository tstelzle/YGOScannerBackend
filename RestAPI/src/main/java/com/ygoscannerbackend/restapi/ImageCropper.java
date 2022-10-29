package com.ygoscannerbackend.restapi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ImageCropper {

    public static BufferedImage autoCropWhiteBorder(BufferedImage sourceImage) {
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        boolean firstFind = true;
        for (int x = 0; x < sourceImage.getWidth(); x++) {
            for (int y = 0; y < sourceImage.getWidth(); y++) {
                // pixel is not empty
                if (sourceImage.getRGB(x, y) != 0) {

                    // we walk from left to right, thus x can be applied as left on first finding
                    if (firstFind) {
                        left = x;
                    }

                    // update right on each finding, because x can grow only
                    right = x;

                    // on first find apply y as top
                    if (firstFind) {
                        top = y;
                    } else {
                        // on each further find apply y to top only if a lower has been found
                        top = Math.min(top, y);
                    }

                    // on first find apply y as bottom
                    if (bottom == 0) {
                        bottom = y;
                    } else {
                        // on each further find apply y to bottom only if a higher has been found
                        bottom = Math.max(bottom, y);
                    }
                    firstFind = false;
                }
            }
        }

        return sourceImage.getSubimage(left, top, right - left, bottom - top);
    }

    public static BufferedImage createBufferedImage(File file) throws IOException {
        return ImageIO.read(file);
    }

    public static File createFile(BufferedImage bufferedImage, File file) throws IOException {
        ImageIO.write(bufferedImage, Files.probeContentType(file.toPath()), file);
        return file;
    }
}
