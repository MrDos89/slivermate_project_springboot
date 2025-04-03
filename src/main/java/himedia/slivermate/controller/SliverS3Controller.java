package himedia.slivermate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import himedia.slivermate.service.SliverS3Service;


@RestController
@RequestMapping("/s3")
public class SliverS3Controller {
    @Autowired
    private SliverS3Service sliverS3Service;

    @GetMapping("/presigned-url")
    public String getPresignedUrl(@RequestParam String bucketName, @RequestParam String fileName) {
        return sliverS3Service.generatePreSignedUrl(bucketName, fileName);
    }
}