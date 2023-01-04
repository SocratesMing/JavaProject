package com.szm.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenGenerater extends IntGenerator{
    private int currentEventValue = 0;
    @Override
    public synchronized  int next() {
        ++currentEventValue;
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerater());
    }
}


abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void canceled(){canceled=true;};

    public boolean isCanceled(){return canceled;};

}

class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator intGenerator, int id) {
        this.intGenerator = intGenerator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even");
                intGenerator.canceled();
            } else {
                System.out.println(val+"is even");
            }
        }

    }

    public static void test(IntGenerator intgen, int count) {
        System.out.println("press contro-c to exit it");
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            pool.execute(new EvenChecker(intgen, i));
        }

        pool.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp,10);
    }
}