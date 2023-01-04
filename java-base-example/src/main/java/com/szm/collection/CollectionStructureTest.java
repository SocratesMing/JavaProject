package com.szm.collection;

import org.junit.Test;

import java.util.*;

public class CollectionStructureTest {
    public static void main(String[] args) {
        // int i = Integer.parseInt("1234");
        // float v = Float.parseFloat("123.5");
        // double aDouble = Double.parseDouble("34.67");
        // System.out.println(i);
        // System.out.println(v);
        // System.out.println(aDouble);
        String ss = "hello world";
        StringBuffer sb = new StringBuffer("33");
        System.out.println("666"=="666");

    }

    @Test
    public void collectionsTest() {
        List<Integer> list = new ArrayList();
        list.add(12);
        list.add(33);
        list.add(17);
        list.add(5);
        list.add(5);
        list.add(5);
        System.out.println(list);   //[12, 33, 17, 5, 5, 5]
        Collections.reverse(list);  //翻转集合
        System.out.println(list);   //[5, 5, 5, 17, 33, 12]
        Collections.shuffle(list);  //打乱集合
        System.out.println(list);   //[33, 5, 5, 12, 5, 17]
        Collections.sort(list);     //排序
        System.out.println(list);   //[5, 5, 5, 12, 17, 33]
        System.out.println(Collections.max(list));  //最大值
        System.out.println(Collections.min(list));  //最小值
        System.out.println(Collections.frequency(list,5));  //出现了三次

        //复制的list的正确用法，需要调用asList
        List list2 = Arrays.asList(new Integer[list.size()]);
        Collections.copy(list2, list);
        System.out.println(list2);

        Collections.replaceAll(list, 5, 99);    //替换所有对象为新的对象
        System.out.println(list);   //[99, 99, 99, 12, 17, 33]


    }

    @Test
    public void ArraysTest() {
        int[] arr = {1, 3, 4, 5};
    }
}


