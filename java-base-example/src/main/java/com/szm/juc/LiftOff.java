package com.szm.juc;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable{
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + " [" + (countDown > 0 ? countDown : "lift Off") + "]";
    }
    @SneakyThrows
    @Override
    public void run() {
        while (countDown-- > 0) {
//            TimeUnit.SECONDS.sleep(1);
            System.out.print(status()+", \n");
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            new Thread(new LiftOff(10)).start();
        }
    }
}
