package com.elammari.leadExtractor.api;


import com.elammari.leadExtractor.model.Image;
import com.elammari.leadExtractor.utils.ImageParse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import  static com.elammari.leadExtractor.utils.Extractors.*;

import java.io.File;

@RestController
public class Controller {
   @PostMapping("/card")
    public Image card(@RequestBody String[] img) throws Exception {
       MultipartFile m= base64ToMultipart(String.join("/", img));
       File file = convertMultiPartToFile(m);
       String value = ImageParse.parseImage(file.getPath());
       return new Image(extractName(value),extractEmail(value),extractPhone(value),extractWebSite(value));

   }



}
