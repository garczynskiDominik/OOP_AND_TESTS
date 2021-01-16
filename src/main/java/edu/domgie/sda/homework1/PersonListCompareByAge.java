package edu.domgie.sda.homework1;

import java.util.Comparator;

public class PersonListCompareByAge implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge().compareTo(person2.getAge());
    }
}
