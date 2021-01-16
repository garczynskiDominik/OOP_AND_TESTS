package edu.domgie.sda.homework1;

import java.util.Comparator;

public class PersonListCompareBySex implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getSex().compareTo(person2.getSex());
    }
}
