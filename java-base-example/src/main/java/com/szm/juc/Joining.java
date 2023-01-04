package com.szm.juc;

public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleepy = new Sleeper("sleepy", 1500),
                grumy = new Sleeper("grumy", 1500);
        Joiner
                dopey = new Joiner("dopey", sleepy),
                doc = new Joiner("Doc", grumy);
        grumy.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted." + " is interrupt():" + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");

    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
        }
        System.out.println(getName() + " join complete");
    }
}
