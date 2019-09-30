package com.example.ocr.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.*;

public class PrintABC implements Runnable {

    private static final int PRINT_COUNT = 10;

    private final ReentrantLock reentrantLock;

    private final Condition thisCondtion;

    private final Condition nextCondtion;

    private final String printChar;

    public PrintABC(ReentrantLock reentrantLock, Condition thisCondtion, Condition nextCondtion, String printChar) {
        this.reentrantLock = reentrantLock;
        this.thisCondtion = thisCondtion;
        this.nextCondtion = nextCondtion;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        reentrantLock.lock();
        try {
            for (int i = 0; i < PRINT_COUNT; i++) {
                System.out.print(printChar);
                System.out.println("线程名："+Thread.currentThread().getName());
                nextCondtion.signal();
                if (i < PRINT_COUNT - 1) {
                    try {
                        thisCondtion.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();

//        Thread a = new Thread(new PrintABC(reentrantLock, conditionA, conditionB, "A"));
//        Thread b = new Thread(new PrintABC(reentrantLock, conditionB, conditionC, "B"));
//        Thread c = new Thread(new PrintABC(reentrantLock, conditionC, conditionA, "C"));
//
//        a.start();
//        Thread.sleep(100);
//        b.start();
//        Thread.sleep(100);
//        c.start();

        ExecutorService pool =  newCachedThreadPool();
        pool.submit(new PrintABC(reentrantLock, conditionA, conditionB, "A"));
        Thread.sleep(100);
        pool.submit(new PrintABC(reentrantLock, conditionB, conditionC, "B"));
        Thread.sleep(100);
        pool.submit(new PrintABC(reentrantLock, conditionC, conditionA, "C"));
        pool.shutdown();


    }
}
