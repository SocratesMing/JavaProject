package guava.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class demo01 {

    @Test
    public void testMultiSet() {
        Multiset<String> ms1 = HashMultiset.create(Arrays.asList("a", "b", "a"));
        Multiset<String> ms2 = HashMultiset.create(Arrays.asList("a", "d", "e", "f","a"));
        System.out.println("szie："+ms2.size());     //szie：5
        System.out.println("count："+ms2.count("a"));    //count：2
        System.out.println("count："+ms2.count("a"));    //count：2
        System.out.println(ms2.setCount("b",3));
        System.out.println(ms2.elementSet());   //[a, b, d, e, f]
        System.out.println(ms2.entrySet()); //[a x 2, b x 3, d, e, f]
        System.out.println("szie："+ms2.size()); //8


    }
    @Test
    public void testMuliSets() {
        Multiset<String> ms1 = HashMultiset.create(Arrays.asList("a", "b", "a"));
        Multiset<String> ms2 = HashMultiset.create(Arrays.asList("a", "d", "e", "f","a"));
        Multiset<String> difference = Multisets.difference(ms1, ms2);   //差集
        System.out.println(difference);
        System.out.println(Multisets.union(ms1, ms2)); //并集

        Multiset<String> superMultiset = HashMultiset.create(Arrays.asList("a", "b", "a"));
        Multiset<String> subMultiset = HashMultiset.create(Arrays.asList("a", "b"));
        //判断是否包含
        System.out.println(Multisets.containsOccurrences(superMultiset,subMultiset));
    }
}
