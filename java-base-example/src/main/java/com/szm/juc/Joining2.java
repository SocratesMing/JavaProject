package com.szm.juc;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

public class Joining2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"start");
        new Demo01("1", 1, 10,10).join();
        TimeUnit.SECONDS.sleep(2);
        new Demo01("2", 1, 20,5).join();
        System.out.println(Thread.currentThread().getName()+"stop");
    }
}

class Demo01 extends Thread {
    private int time;
    private int start;
    private int step;
    public Demo01(String name,int time,int start,int step) {
        super(name);
        this.time = time;
        this.start = start;
        this.step = step;
        start();
    }

    @Override
    public void run() {
        for (int i = start; i < start+step; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(getName()+"---"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}