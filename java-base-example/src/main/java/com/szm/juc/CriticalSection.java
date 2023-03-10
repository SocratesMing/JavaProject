package com.szm.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CriticalSection {
    static void testApproaches(PairManager pma1, PairManager pma2) {
        ExecutorService pool = Executors.newCachedThreadPool();
        PairManipulator
                pm1 = new PairManipulator(pma1),
                pm2 = new PairManipulator(pma2);

        PairChecker
                pc1 = new PairChecker(pma1),
                pc2 = new PairChecker(pma2);

        pool.execute(pm1);
        pool.execute(pm2);
        pool.execute(pc1);
        pool.execute(pc2);

        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }

        System.out.println("pm1: " + pm1 + "\npm2" + pm2);
        System.exit(0);

    }

    public static void main(String[] args) {
        PairManager
                pm1 = new PairManger1(),
                pm2 = new PairManger2();

        testApproaches(pm1, pm2);
    }
}

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair(){this(0, 0);}

    public int getX() {return x;}

    public int getY() {return y;}

    public void incrementX() {x++;}
    public void incrementY() {y++;}

    @Override
    public String toString() {
        return "Pair{x=" + x + ", y=" + y + '}';
    }
    public class PairValueNotEqualException extends RuntimeException {
        public PairValueNotEqualException() {
            super("Pair Value not equal:"+Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNotEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(p.getX(), p.getY());
    }

    protected void store(Pair p) {
        storage.add(p);

        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void incremenet();
}

class PairManger1 extends PairManager {

    @Override
    public synchronized void incremenet() {
        p.incrementX();
        p.incrementY();
        store(p);
    }
}

class PairManger2 extends PairManager {

    @Override
    public void incremenet() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}


class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.incremenet();
        }
    }

    @Override
    public String toString() {
        return "Pair= " + pm.getPair() + " checkCounter= " + pm.checkCounter.get();}
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }


    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}
