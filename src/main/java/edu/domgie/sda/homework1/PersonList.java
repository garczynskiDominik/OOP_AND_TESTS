package edu.domgie.sda.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PersonList {


    public static void main(String[] args) {
//new Person
        Person dominik = new Person("Dominik", "Garczynski", 94235689751L, 27, "male");
        Person tomek = new Person("Tomek", "Kloc", 96235689374L, 26, "male");
        Person krzysiek = new Person("Krzysiek", "Mazur", 95235689734L, 25, "male");
        Person dawid = new Person("Dawid", "Zdeb", 912349751L, 21, "male");
        Person kasia = new Person("Kasia", "Oczko", 93235439751L, 23, "female");
        Person jacek = new Person("Jacek", "Stepien", 25765689751L, 16, "male");
        Person natalia = new Person("Natalia", "Starenga", 27265987452L, 14, "female");
        Parent ryszard = new Parent("Ryszard", "Garczynski", 54896325871L, 67, "male", new ArrayList());
        Person arek = new Person("Arek", "Kiliszek", 92634578469L, 29, "male");
        Parent maria = new Parent("Maria", "Orzech", 603265987512L, 62, "female", new ArrayList());

//add childs to Paretn list, Ryszard is parent
        ryszard.addChildToParentList(dominik);
        ryszard.addChildToParentList(tomek);
        ryszard.addChildToParentList(krzysiek);

        //add childs to Parent lit, Maria is parent
        maria.addChildToParentList(natalia);
        maria.addChildToParentList(jacek);
        maria.addChildToParentList(kasia);

        List<Person> personList = new ArrayList<>();
//add Person to PersonList
        personList.add(dominik);
        addPersonToList(tomek, personList);
        addPersonToList(krzysiek, personList);
        addPersonToList(dawid, personList);
        addPersonToList(kasia, personList);
        addPersonToList(jacek, personList);
        addPersonToList(ryszard, personList);
        addPersonToList(natalia, personList);
        addPersonToList(arek, personList);
        addPersonToList(maria, personList);
        // after add dawid one more time, program throw exception
//        addPersonToList(dawid,personList);


        System.out.println("\nList sorted by Age\n");
        Collections.sort(personList, new PersonListCompareByAge());
        personList.forEach(System.out::println);

        System.out.println("\nList sorted by name\n");
        Collections.sort(personList, Person::compareTo);
        personList.forEach(el -> System.out.println(el));


        System.out.println("\nList sorted by surname\n");
        Collections.sort(personList, new PersonListCompareByLastName());
        personList.forEach(el -> System.out.println(el));


        System.out.println("\nList sorted by sex\n");
        Collections.sort(personList, new PersonListCompareBySex());
        personList.forEach(el -> System.out.println(el));


        System.out.println("\nList sorted by Adult, female by name\n");
        List<Person> personAdultFemaleList = personList.stream()
                .filter(el -> el.getAge() > 18)
                .filter(el -> el.getSex() == "female")
                .collect(Collectors.toList());
        Collections.sort(personList, Person::compareTo);
        personAdultFemaleList.forEach(el -> System.out.println(el));

        System.out.println("\nList sorted by Adult, male by name\n");
        List<Person> personAdultMqleList = personList.stream()
                .filter(el -> el.getAge() > 18)
                .filter(el -> el.getSex() == "male")
                .collect(Collectors.toList());
        Collections.sort(personList, Person::compareTo);
        personAdultMqleList.forEach(el -> System.out.println(el));
    }

    public static void addPersonToList(Person person, List list) {
        if (!list.contains(person)) {
            list.add(person);
        } else {
            throw new PersonAlreadyInsertedException("This person is on the list" + person);
        }
    }
}
