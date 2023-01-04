package szm;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {

    @JSONField(name = "AGE")
    private int age;

    @JSONField(name="FULL NAME")
    private String name;

//    @JSONField(name = "DATE OF BIRTH")
//    private Date dateofBith;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
//        this.dateofBith = dateofBith;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
//                ", dateofBith=" + dateofBith +
                '}';
    }

    //get和set函数时必须的
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
