package com.szm.juc;

import java.util.concurrent.TimeUnit;

public class SimpleDaemon implements Runnable{

    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.println("interrupt");
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SimpleDaemon());
//            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all daemon start");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
