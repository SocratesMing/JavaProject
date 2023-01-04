package com.szm.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExceptionThread implements Runnable{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run by " + thread);
        System.out.println("thread caught by" + thread.getUncaughtExceptionHandler());
        throw new RuntimeException("exception");
    }

    public static void main(String[] args) {
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            pool.execute(new ExceptionThread());
        } catch (RuntimeException e) {
//            e.printStackTrace();
            System.out.println("Exception is handled");
        }
    }
}





