package szm;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArgTest {
    private int age;
    private String name;
    private final int sex;

    public static void main(String[] args) {
        ArgTest tom = new ArgTest(20, "tom", 0);
        System.out.println(tom);
    }

}
