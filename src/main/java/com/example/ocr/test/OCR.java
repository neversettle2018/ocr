package com.example.ocr.test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class OCR {

    public static String doOCR(String filePath) {

        double start = System.currentTimeMillis();

        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            return "图片不存在";
        }
        String fileName = imageFile.getName();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (("BMP".equalsIgnoreCase(suffix)) || ("GIF".equalsIgnoreCase(suffix)) || ("PNG".equalsIgnoreCase(suffix)) || ("JPG".equalsIgnoreCase(suffix)) || ("JPEG".equalsIgnoreCase(suffix))) {

            ITesseract instance = new Tesseract();

            File tessDataFolder = LoadLibs.extractTessResources("tessdata");

            instance.setLanguage("chi_sim+eng");

            instance.setDatapath(tessDataFolder.getAbsolutePath());

            String result = "";
            try {
                System.out.println("正在识别中...");
                result = instance.doOCR(imageFile);
                double end = System.currentTimeMillis();
                System.out.println("识别成功,耗时" + (end - start) / 1000 + " s");
            } catch (TesseractException e) {
                System.err.println(e.getMessage());
            }
            return result;

        } else {
            return "只支持JPG,BMP,GIF,PNG格式！";
        }
    }

}
