package com.elammari.leadExtractor.utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageParse {

    public static String parseImage(String filePath) {
         //TO DO REFACTOR
        File imageFile = new File(filePath);
        ITesseract instance = new Tesseract();
        instance.setLanguage("fra");
        //instance.setDatapath("/home/ubuntu/tessdata");
        instance.setDatapath("C://tessdata");
        try {
            BufferedImage in = ImageIO.read(imageFile);
            BufferedImage newImage =
            Scalr.resize(in, Scalr.Method.ULTRA_QUALITY, 1480, 650);
            String result = instance.doOCR(newImage);
            return result;

        } catch (TesseractException | IOException e) {
            System.err.println(e.getMessage());
            return "Error while reading image";
        }
    }
}
