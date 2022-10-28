package com.example.ygoscannerbackend.controller;

import com.example.ygoscannerbackend.FileUploadUtil;
import com.example.ygoscannerbackend.ImageCropper;
import com.example.ygoscannerbackend.TextExtractor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @PostMapping
    public String ocrImage(@RequestParam("image") MultipartFile multipartFile) {

        String imageName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        File imageFile = FileUploadUtil.getFile("photos/", imageName, multipartFile);
        if (!FileUploadUtil.checkValidImage(imageFile)) {
            return "This file is no image";
        }

/*        try {
            BufferedImage bufferedImage = ImageCropper.autoCrop(ImageCropper.createBufferedImage(imageFile));
            imageFile = ImageCropper.createFile(bufferedImage, imageFile);
        }
        catch (IOException e) {
            return "Autocroping failed";
        }*/

        String text = TextExtractor.getImageText(imageFile);

        return String.format("Extracted text:%s", text);
    }
}



