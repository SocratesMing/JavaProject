package com.szm.juc;

import java.util.concurrent.TimeUnit;

public class LongTime {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        LongTime.main(new String[]{});
    }
}
