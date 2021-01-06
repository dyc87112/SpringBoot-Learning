package com.didispace.chapter43;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
@Slf4j
public class UploadController {

    @Value("${file.upload.path}")
    private String path;

    @GetMapping("/")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String create(@RequestPart MultipartFile file) {

        String fileName = file.getOriginalFilename();
        String filePath = path + fileName;

        String message;
        File dest = new File(filePath);
        try {
            file.transferTo(dest);
            message = "Upload file success : " + dest.getAbsolutePath();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            message = "Upload file failed : " + e.getMessage();
        }
        return message;
    }

}