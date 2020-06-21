package com.elammari.leadExtractor;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.imgscalr.Scalr;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ImageParse {

    public static String parseImage(String filePath) {

        File imageFile = new File(filePath);
        ITesseract instance = new Tesseract();
        instance.setLanguage("fra");
       // instance.setDatapath("D://tessdata");
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
