package edu.domgie.sda.homework1;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private long IdNumber;
    private int age;
    private String sex;

    public Person(String firstName, String lastName, long idNumber, int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        IdNumber = idNumber;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(long idNumber) {
        IdNumber = idNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person=" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IdNumber=" + IdNumber +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getFirstName)
                .thenComparing(Person::getLastName)
                .thenComparingLong(Person::getIdNumber)
                .thenComparingInt(Person::getAge)
                .thenComparing(Person::getSex)
                .thenComparingInt(Person::getAge)
                .compare(this, o);
    }
}

