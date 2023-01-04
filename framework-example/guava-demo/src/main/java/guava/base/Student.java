package guava.base;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

public class Student implements Comparable<Student> {
    private String lastName;
    private String firstName;
    private int zipCode;

    public Student(String lastName, String firstName, int zipCode) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public int compareTo(Student that) {
        return ComparisonChain.start()
                .compare(this.firstName, that.firstName)
                .compare(this.lastName, that.lastName)
                .compare(this.zipCode, that.zipCode, Ordering.natural().nullsLast()).result();
    }
}
