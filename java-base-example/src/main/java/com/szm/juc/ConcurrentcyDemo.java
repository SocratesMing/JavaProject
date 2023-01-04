package com.szm.juc;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentcyDemo {
    public static void main(String[] args) {
        System.out.println(Math.round(11.5));
        long x=400;
        float y=23;
        System.out.println(x);
        System.out.println(y);
        int[] arr1 = new int[10];
        int[] arr2 = {1,2,3,4};
        int[] arr3 = new int[]{1,2,3,4};
        int[][] arr4 = {{1, 2, 3}, {4, 5, 6}};

        int a= 3;
        System.out.println(a++);    //先赋值后运算，输出3然后+1
        System.out.println(++a);    //先运算后赋值，输出5

        System.out.println(5/4);    //1
        System.out.println(7/4);    //1
        System.out.println(-7/4);    //-1
        System.out.println(-5/4);    //-1
        System.out.println(5f/4);    //1.25
        String s = 5 + 6 > 3 ? "big" : "small"; //s=big
        System.out.println(s);


    }
}
