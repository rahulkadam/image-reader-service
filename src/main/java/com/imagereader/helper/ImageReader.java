package com.imagereader.helper;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class ImageReader {

    public String getImgText(File imageLocation) {
        ITesseract instance = new Tesseract();
        try {
//            instance.setDatapath("resources/");
            String imgText = instance.doOCR(imageLocation);
            return imgText;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
