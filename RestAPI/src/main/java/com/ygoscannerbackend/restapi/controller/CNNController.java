package com.ygoscannerbackend.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/cnn")
public class CNNController {

    @PostMapping
    public ResponseEntity<String> postCNNImage(@RequestParam("image") MultipartFile multipartFile) {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

}