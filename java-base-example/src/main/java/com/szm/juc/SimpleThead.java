package com.szm.juc;

public class SimpleThead extends Thread{

    private int count=5;
    private static int threadCount=0;

    public SimpleThead() {
    super(Integer.toString(++threadCount));
    start();    //构造的时候就执行start方法
    }

    @Override
    public String toString() {
        return "# "+getName()+" ["+count+"]";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if(--count==0) return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new SimpleThead();
        }
    }

}
