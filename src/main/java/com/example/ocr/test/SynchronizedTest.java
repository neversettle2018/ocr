package com.example.ocr.test;

public class SynchronizedTest {

    //普通方法锁住的是当前实例对象
    private synchronized void test1() {
        for (int x = 0; x < 5; x++) {

            System.out.println("test1---" + x);
        }
    }

    private void test2() {
        //普通代码块锁住的是当前实例对象
        synchronized (this) {
            for (int x = 0; x < 5; x++) {

                System.out.println("---test2---" + x);
            }
        }
    }

    //静态代码块锁住的是当前当前类的Class对象
    private static synchronized void test3() {
        for (int x = 0; x < 5; x++) {

            System.out.println("------test3---" + x);
        }
    }

    private static void test4() {
        synchronized (SynchronizedTest.class) {
            for (int x = 0; x < 5; x++) {

                System.out.println("---------test4---" + x);
            }
        }
    }

    public static void main(String[] args) {

        String a = "1";
        String b = "1";

        System.out.println(a == b);

//        SynchronizedTest synchronizedTest = new SynchronizedTest();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronizedTest.test1();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronizedTest.test2();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test3();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                test4();
//            }
//        }).start();
    }
}
