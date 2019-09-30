package com.example.ocr.test;

import java.awt.*;

public class test  implements Runnable{

    public synchronized void m1(){
        System.out.println("m1");
    }

    public synchronized void m2(){
        System.out.println("m2");
    }

    @Override
    public void run() {
        m1();
    }

    public static void main(String[] args) {
//        test test = new test();
//
//        Thread thread = new Thread(test);
//        thread.start();
//
//        test.m2();
            //获取唯一可用的对象
//        Singleton object = Singleton.getSingleton();
//        object.showMessage();

//         WaterMaskImgUtils.pressTextToRightBottom("D:\\11111.jpg","加水印","宋体",1,10, Color.black,1,"1");
        try {
            WatermarkUtil.setTextWaterMarkForImage("D:\\0000.jpg","D:\\0001.jpg","hxj",10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
