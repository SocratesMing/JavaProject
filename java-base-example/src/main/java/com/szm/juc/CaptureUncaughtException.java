package com.szm.juc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool(new HanderThreadFactory());
        pool.execute(new ExceptionThread2());
        ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
    }
}

class ExceptionThread2 implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println(
                "[eh] = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

//实现UncaughtExceptionHandler接口来定义自己的线程捕获异常类
class MyUncaughtException implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("[caught] " + e);
    }
}

//实现ThreadFactory接口来定义处理线程的工厂类
class HanderThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + "[ creating new Thread]");
        Thread t = new Thread(r);
        System.out.println("[created] " + r);
        t.setUncaughtExceptionHandler(new MyUncaughtException());   //设置异常属性为自定义的异常
        System.out.println("[eh]= " + t.getUncaughtExceptionHandler());
        return t;
    }
}