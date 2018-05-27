package com.imagereader.rest;

import com.imagereader.helper.ImageReader;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/shift")
public class ImageController {

    @Autowired
    private ImageReader imageReader;

    @PostMapping("/image/text")
    public String getImageText(@RequestParam("file") MultipartFile uploadfile) {
        if (uploadfile.isEmpty()) {
            return "please select a file!";
        }
        try {
            InputStream is = uploadfile.getInputStream();
            File f = new File(uploadfile.getOriginalFilename());
            FileUtils.copyInputStreamToFile(is, f);
            return imageReader.getImgText(f);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
