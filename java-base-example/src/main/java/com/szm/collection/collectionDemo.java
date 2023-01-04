package com.szm.collection;



import org.junit.Test;

import java.util.*;

public class collectionDemo {

    @Test
    public void test01() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add("test");
        coll.add("test");
        coll.add(new Person("小明", 12));
        coll.add(false);
        Person p = new Person("小红", 22);
        coll.add(p);

        /*
         * 使用集合的注意事项
         * 如果添加的是对象，对象需要实现equals方法
         *
         * */
        System.out.println("===========contains============");
        //contains：调用的是对象类的equals方法，因此对象的类需要实现equals方法
        System.out.println(coll.contains("test")); //true
        //不写equal  false
        System.out.println(coll.contains(new Person("小明", 12)));

        //containsAll，判断集合时候在另一个集合中
        System.out.println("===========containsAll============");
        Collection coll2 = Arrays.asList(123, 456); //注意这种声明方式
        Collection coll3 = Arrays.asList(123, 457);
        System.out.println(coll.containsAll(coll2));
        System.out.println(coll.containsAll(coll3));

        //只能移除一个
        System.out.println("===========remove============");
        System.out.println(coll);
        coll.remove("test");
        System.out.println(coll);

        System.out.println("===========removeAll============");
        coll.add("test");
        System.out.println(coll);
        coll.remove("test");
        System.out.println(coll);


        System.out.println("===========retainAll============");
        Collection coll5 = Arrays.asList(123, 456);
        coll.retainAll(coll5);
        System.out.println(coll);  //求交际并返回给当前集合

    }


    @Test
    public void test02() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add("test");
        coll.add("test");
        coll.add(new Person("小明", 12));
        coll.add(false);
        Person p = new Person("小红", 22);
        coll.add(p);


        Collection coll1 = new ArrayList();

        coll1.add(123);
        coll1.add(456);
        coll1.add("test");
        coll1.add("test");
        coll1.add(new Person("小明", 12));
        coll1.add(false);
        Person p1 = new Person("小红", 22);
        coll1.add(p);

        //判断是否相等
        System.out.println("===========equals============");
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test03() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add("test");
        coll.add("test");
        coll.add(new Person("小明", 12));
        coll.add(false);
        Person p = new Person("小红", 22);
        coll.add(p);

        //集合转数组
        System.out.println("===========toArray============");
        Object[] objects = coll.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }

        //数组转集合用Arrys的静态方法asList
        List<Integer> ints = (List<Integer>) Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(ints);
    }

    @Test
    public void test04() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add("test");
        coll.add("test");
        coll.add(new Person("小明", 12));
        coll.add(false);
        Person p = new Person("小红", 22);
        coll.add(p);

        System.out.println("===========集合元素的遍历,方式1==========");
        //每次遍历都需要新的iterator变量
        //remove 方法一定要在next后使用
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("test".equals(obj)) {
                iterator.remove(); //
            }
        }

        System.out.println("===========集合元素的遍历,方式2==========");
        //主要思想是遍历coll每次取出元素赋值给o，因此这种方式不能修改数据
        for (Object o : coll) {
            System.out.println(o);
        }



    }

}

