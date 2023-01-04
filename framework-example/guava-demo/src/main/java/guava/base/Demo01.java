package guava.base;


import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Demo01 {

    @Test
    public void testNull() {
        System.out.println("test");
        Optional<Integer> opt = Optional.of(5);//赋值为具体的对象
        System.out.println(opt.get());
        System.out.println(opt.isPresent());
        System.out.println(opt.get() instanceof Integer);

        System.out.println("absent test----");
        Optional<String> strOpt = Optional.absent();//null值
        System.out.println(strOpt.isPresent());
    }

    @Test
    public void TestObject() {
        System.out.println("\nequal---");
        Objects.equal("a", "a");
        Objects.equal(null, "a");

        System.out.println("\nhashCode---");
        // 哈希是计算每个字段的哈希值
        Person szm = new Person("szm", 12, 1, "125649");
        System.out.println(Objects.hashCode(szm));  //564873900
        System.out.println(Objects.hashCode(szm.hashCode()));   //564873900
        System.out.println(Objects.hashCode("szm", 12, 1, "125649"));  //564873869
        System.out.println(szm.hashCode());     //564873869

        System.out.println("\nequal---");
        String string = MoreObjects.toStringHelper("MyObject").add("name", "szm").add("age", 12).toString();
        System.out.println(string);
        String string1 = MoreObjects.toStringHelper(this).add("test", "pass").toString();
        System.out.println(string1);

        System.out.println("\ncompareTo---");

        Student student1 = new Student("zm", "s", 1);
        Student student2 = new Student("zm", "o", 1);
        Student student3 = new Student("zm", "s", 2);

        List<Student> studentList = Arrays.asList(student1, student2, student3);
        studentList.sort(Student::compareTo);
        System.out.println(studentList);
    }

    @Test
    public void testOrder() {

    }



}
