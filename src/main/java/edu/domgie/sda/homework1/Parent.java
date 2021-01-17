package edu.domgie.sda.homework1;

import java.util.ArrayList;
import java.util.List;

public class Parent extends Person {
    private List<Person> listOfChild;

    public Parent(String firstName, String lastName, long idNumber, int age, String sex) {
        super(firstName, lastName, idNumber, age, sex);
        this.listOfChild= new ArrayList<Person>();
    }
    public void addChildToParentList(Person person) {
        listOfChild.add(person);
    }
    @Override
    public String toString() {
        return "Person = " +
                getFirstName() + ", " +
                getLastName()
                + ", PESEL:" + getIdNumber()
                + ", age: " + getAge()
                + ", sex:" + getSex()
                + " childs: " + listOfChild;
    }
}
