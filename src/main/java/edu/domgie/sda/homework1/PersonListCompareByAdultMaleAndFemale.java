package edu.domgie.sda.homework1;

import java.util.Comparator;

public class PersonListCompareByAdultMaleAndFemale implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {

            if (person1.getAge() >18 && person2.getAge()>18) {
                if (person1.getFirstName().compareTo(person2.getFirstName()) != 0) {
                    return person1.getFirstName().compareTo(person2.getFirstName());
                }
            }

        return 0;
    }
}
