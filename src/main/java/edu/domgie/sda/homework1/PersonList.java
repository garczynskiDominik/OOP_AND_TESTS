package edu.domgie.sda.homework1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonList extends Parent{
    public PersonList(String firstName, String lastName, long idNumber, int age, String sex, List listOfChild) {
        super(firstName, lastName, idNumber, age, sex, listOfChild);
    }

    public static void main(String[] args) {
        Person dominik = new Person("Dominik", "Garczynski", 94235689751L, 27, "male");
        Person tomek = new Person("Tomek", "Kloc", 96235689374L, 26, "male");
        Person krzysiek = new Person("Krzysiek", "Mazur", 95235689734L, 25, "male");
        Person dawid = new Person("Dawid", "Zdeb", 912349751L, 21, "male");
        Person rafal = new Person("Rafal", "Oczko", 93235439751L, 23, "male");
        Person jacek = new Person("Jacek", "Stepien", 94765689751L, 24, "male");

        Parent ryszard = new Parent("Ryszard", "Garczynski", 54896325871L, 67, "male", new ArrayList());

        List<Person> personList = new ArrayList<>();
            personList.add(dominik);
            personList.add(tomek);
            personList.add(krzysiek);
            personList.add(dawid);
            personList.add(rafal);
            personList.add(jacek);
        Scanner scanner = new Scanner(System.in);


        personList.forEach(el-> System.out.println(el));

    }
}
