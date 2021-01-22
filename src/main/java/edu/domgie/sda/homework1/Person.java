package edu.domgie.sda.homework1;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private long IdNumber;
    private Integer age;
    private String sex;

    public Person(String firstName, String lastName, long idNumber, int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        IdNumber = idNumber;
        this.age = age;
        this.sex = sex;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getIdNumber() {
        return IdNumber;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person = " +
                firstName +
                ", " + lastName +
                ", PESEL:" + IdNumber +
                ", age: " + age +
                ", sex:" + sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return IdNumber == person.IdNumber && age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, IdNumber, age, sex);
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

