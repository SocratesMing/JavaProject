package szm;

import org.junit.FixMethodOrder;
import org.junit.Test;

@FixMethodOrder
public class TestMethodOrder2 {
    @Test
    public void testA() {
        System.out.println("first");
    }
    @Test
    public void testB() {
        System.out.println("second");
    }
    @Test
    public void testC() {
        System.out.println("third");
    }
}
