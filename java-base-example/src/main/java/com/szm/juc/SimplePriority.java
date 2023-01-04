package com.szm.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriority implements Runnable{
    private int count=5;
    private volatile double d;
    private int priority;

    public SimplePriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ":" + count;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);//设置当前线程的优先级
        while (true) {
            for (int i = 0; i < 100000; i++) {
                d += (Math.E + Math.PI) / (double) i;
                if (i % 1000 == 0)
                    Thread.yield();
//                System.out.println("d:--"+d);
            }
            System.out.println(this);
            if(--count==0) return;
        }
    }

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            pool.execute(new SimplePriority(Thread.MIN_PRIORITY)); //min=1
        pool.execute(new SimplePriority(Thread.MAX_PRIORITY));  //max=10 normal=5
        pool.shutdown();
    }
}
