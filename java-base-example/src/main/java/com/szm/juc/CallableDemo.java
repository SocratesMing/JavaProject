package com.szm.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<Future<String>> res = new ArrayList<>();

        for (int i = 0; i < 10; i++) 
            res.add(pool.submit(new ReturnValue(i)));

        for (Future<String> re : res) { //取出每个Future<String>对象调用get方法
            try {
                System.out.println(re.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                
                pool.shutdown();
            }
        }
    }
}


class ReturnValue implements Callable<String> {

    int id;

    public ReturnValue(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "return value is " + id;
    }
}
