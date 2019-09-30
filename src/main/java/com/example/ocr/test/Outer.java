package com.example.ocr.test;

class Outer{
    int a=5;
    static int b=6;
    void show() {
        System.out.println("hello world");
    }
    class Inner{
        void use() {
            System.out.println(a);//5
            System.out.println(b);//6
            show();//hello world

        }
    }
    void create() {
        new Inner().use();
    }

}

 class Demo {

    public static void main(String[] args) {
        new Outer().create();
        Outer.Inner inner = new Outer().new Inner();
        inner.use();

    }

}