package edu.domgie.sda.homework1;

import java.util.List;

public class Parent extends Person {
    private List listOfChild;

    public Parent(String firstName, String lastName, long idNumber, int age, String sex, List listOfChild) {
        super(firstName, lastName, idNumber, age, sex);
        this.listOfChild=listOfChild;
    }

    public void setListOfChild(List listOfChild) {
        this.listOfChild = listOfChild;
    }

    public List getListOfChild() {
        return listOfChild;
    }

}
