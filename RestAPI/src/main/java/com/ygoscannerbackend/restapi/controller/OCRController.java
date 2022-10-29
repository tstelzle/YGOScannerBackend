package com.ygoscannerbackend.restapi.controller;

import com.ygoscannerbackend.restapi.FileUploadUtil;
import com.ygoscannerbackend.restapi.TextExtractor;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/ocr")
public class OCRController {

    @PostMapping
    public ResponseEntity<String> postOCRImage(@RequestParam("image") MultipartFile multipartFile) {
        log.info("Received Request.");

        String imageName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        File imageFile = FileUploadUtil.getFile("./photos/", imageName, multipartFile);
        if (!FileUploadUtil.checkValidImage(imageFile)) {
            return new ResponseEntity<>("File Is No Image", HttpStatus.BAD_REQUEST);
        }

/*        try {
            BufferedImage bufferedImage = ImageCropper.autoCrop(ImageCropper.createBufferedImage(imageFile));
            imageFile = ImageCropper.createFile(bufferedImage, imageFile);
        }
        catch (IOException e) {
            return "Autocroping failed";
        }*/

        TextExtractor textExtractor = new TextExtractor();
        String text = textExtractor.getImageText(imageFile);

        return new ResponseEntity<>(text, HttpStatus.OK);
    }
}



