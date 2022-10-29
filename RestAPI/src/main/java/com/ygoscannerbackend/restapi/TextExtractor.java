package com.ygoscannerbackend.restapi;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class TextExtractor {

    private final Tesseract tesseract;

    public TextExtractor() {
        tesseract = new Tesseract();

        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        tesseract.setDatapath(tessDataFolder.getAbsolutePath());
        tesseract.setLanguage("eng");
    }

    public String getImageText(File file) {
        try {
            return tesseract.doOCR(file);
        } catch (TesseractException e) {
            return String.format("Tesseract Error: %s", e);
        }
    }
}

