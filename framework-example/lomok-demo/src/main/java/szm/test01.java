package szm;


import lombok.val;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class test01 {
    @Test
    public void example() {
        val example = new ArrayList<String>();
        example.add("Test");
        val foo = example.get(0);
        System.out.println(foo);
    }

    @Test
    public void example2() {
        val map = new HashMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
        for (val m : map.entrySet()) {
            System.out.println(m.getKey());
            System.out.println(m.getValue());
            System.out.println("------");
        }
    }
}
