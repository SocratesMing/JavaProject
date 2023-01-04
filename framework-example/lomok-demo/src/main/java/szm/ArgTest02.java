package szm;

import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class ArgTest02 {
    @NotNull private int age;
    private String name;
    @NotNull  private  int sex;

    public static void main(String[] args) {
        ArgTest02 jack = new ArgTest02(2,2); //b
        System.out.println(jack);
    }
}
