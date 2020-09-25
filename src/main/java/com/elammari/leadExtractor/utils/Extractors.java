package com.elammari.leadExtractor.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractors {
    public static  File convertMultiPartToFile(MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }

    public static MultipartFile base64ToMultipart(String base64) {
        try {
            Base64 decoder = new Base64();
            byte[] b = new byte[0];
            b = decoder.decode(base64);

            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }

            return new BASE64DecodedMultipartFile(b, base64);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String extractName(String str){
        System.out.println("Getting the Name");
        final String NAME_REGEX = "([A-Z][a-z]+(?: [A-Z]\\.)? [A-Z][a-z]+)";
        Pattern p = Pattern.compile(NAME_REGEX);
        Matcher m =  p.matcher(str);
        if(m.find()){
            return m.group();
        }
        return "";
    }

    public static String extractEmail(String str) {
        System.out.println("Getting the email");
        final String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        Pattern p = Pattern.compile(EMAIL_REGEX);
        Matcher m = p.matcher(str);   // get a matcher object
        if(m.find()){
            return m.group();
        }
        return "";

    }

    public static String extractPhone(String str){
        System.out.println("Getting Phone Number");
        Pattern p2 = Pattern.compile("(?:(?:(?:\\+\\d{1,3}|00|0 )[\\s]?(?:[\\s]?\\(0\\)[\\s]?)?)|0){1}(?:5[\\s.-]?[2-3]|6[\\s.-]?[13-9]){1}[0-9]{1}(?:[\\s.-]?\\d{2}){3}");
        Matcher m2 = p2.matcher(str);
        while (m2.find()) {
            String phone2 = m2.group();
            if (phone2 != null) {
                return phone2;
            }
        }
        return null;
    }
    public static String extractWebSite(String str){
        System.out.println("Getting WebSite");
        Pattern p1 = Pattern.compile("(https?:\\/\\/)?(www\\.)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)|(https?:\\/\\/)?(www\\.)?(?!ww)[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)");
        Matcher m1 = p1.matcher(str);

        while (m1.find()) {
            String phone1 = m1.group();
            if (phone1 != null) {
                return phone1;
            }
        }
        return null;
    }

}
