package edu.domgie.sda.homework1;

import java.util.ArrayList;
import java.util.List;

public class Parent extends Person {

   public static List<Person> listOfChild;


    public Parent(String firstName, String lastName, long idNumber, int age, String sex) {
        super(firstName, lastName, idNumber, age, sex);
        this.listOfChild= new ArrayList<>();
    }

    public static List<Person> getListOfChild() {
        return listOfChild;
    }

    public void addChildToParentList(Parent parent, Person person) {
        parent.listOfChild.add(person);
//

    }
    @Override
    public String toString() {
        return ""+
                "Person = " +
                getFirstName() + ", " +
                getLastName()
                + ", PESEL:" + getIdNumber()
                + ", age: " + getAge()
                + ", sex:" + getSex()
                + " CHILDS: "
                +getListOfChild();

    }
}
