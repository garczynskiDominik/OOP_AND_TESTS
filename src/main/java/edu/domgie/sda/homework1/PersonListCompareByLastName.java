package edu.domgie.sda.homework1;

import java.util.Comparator;

public class PersonListCompareByLastName implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.getLastName().compareTo(person2.getLastName());
    }
}
