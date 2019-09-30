package com.example.ocr.test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "15289864";
    public static final String API_KEY = "j0pj5Y7HVElkLnmn2LEXKeyO";
    public static final String SECRET_KEY = "FKVbH7EBcGy4DIaqPnXcqE47eACzn2W7";
//
//    public static void main(String[] args) {
//        // 初始化一个AipOcr
//        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
//
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
////        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
////        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//        // 也可以直接通过jvm启动参数设置此环境变量
////        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
//
//        // 调用接口
//        String path = "C:\\Users\\hahaha\\Desktop\\1111.jpg";
//        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));
//
//    }

    public static void main(String[] args) {

//          识别图片
//        String result= OCR.doOCR("C:\\Users\\hahaha\\Desktop\\wenku.jpg");
//        System.out.println(result);


//        System.out.println(result.replaceAll("\\s*", ""));

        //读取txt
//        ReadFile readFile = new ReadFile();
//        String txt = readFile.getTxt("C:\\Users\\hahaha\\Desktop\\新建文本文档 (3).txt");
//        System.out.println(txt);

        //读取word
//        ReadFile readFile = new ReadFile();
//        String   word = readFile.getWord("C:\\Users\\hahaha\\Desktop\\新建 DOCX 文档.docx");
//        System.out.println(word);


//        读取文件解析本本
        double start = System.currentTimeMillis();
        String parse = ParseText.parse("D:\\迅雷下载\\单词讲义 - 副本.pptx");
        double end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) / 1000.0D + " s");
        System.out.println("size:"+parse.length());
        System.out.println("content:"+parse);

    }



}