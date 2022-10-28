package com.example.ygoscannerbackend;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class TextExtractor {

    private static final Tesseract tesseract = new Tesseract();

    public static String getImageText(File file) {
        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        tesseract.setDatapath(tessDataFolder.getAbsolutePath());

        try {
            return tesseract.doOCR(file);
        } catch (TesseractException e) {
            return String.format("Tesseract Error: %s", e);
        }
    }
}

