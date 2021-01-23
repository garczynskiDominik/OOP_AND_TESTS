package edu.domgie.sda.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    public static void main(String[] args) {
        ArrayList<Human> people = new ArrayList<>();
        //DTD czyli Data Transfer Objectt czyli klasa pomocnicza
        // ktora ma przechowywac wycinek danych

        class HumanDTO {
            String name;
            String surname;

            public HumanDTO(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public String getHumanData() {
                return surname + ", " + name;
            }
        }

        //3 obiekty z pierwszego konstruktora gdzie deklaruje enum
        people.add(new Human("Dominik", "Gaczynski", 18, Gender.MAN));
        people.add(new Human("Natalia", "Starenga", 28, Gender.WOMAN));
        people.add(new Human("Wojtek", "Kowalsky", 50, Gender.MAN));

        //3 obiekty z drugiego konstruktora gdzie podajemy skrot płci
        people.add(new Human("Agata", "Pachel", 43, "K"));
        people.add(new Human("Marek", "Koperski", 12, "M"));
        people.add(new Human("Zosia", "Wisniewska", 34, "K"));


        people.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        people.stream().forEach(System.out::println);
        System.out.println("--------------------------------------------------");


        people.stream()
                .filter(human -> human.isOver20AndMan())
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------");
        people.stream().limit(2).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        Collections.sort(people, Human::compareTo);
        people.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        //WAŻNE sortowanie po danym polu
        people.stream()
                .sorted(Comparator.comparing(Human::getAge))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        List<Human> mans = new ArrayList<>();
        mans = people.stream()
                .filter(human -> human.getGender().equals(Gender.MAN))
                .collect(Collectors.toList());
        mans.forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");

        List<Human> woman = new ArrayList<>();
        woman = people.stream()
                .filter(human -> human.getGender().equals(Gender.WOMAN))
                .collect(Collectors.toList());
        woman.forEach(System.out::println);
        List<HumanDTO> humanDTOS = new ArrayList<>();
        for (Human human : people) {
            humanDTOS.add(new HumanDTO(human.getName(), human.getSurname()));
        }
        humanDTOS.forEach(x -> System.out.println(x.getHumanData()));
        System.out.println("---------------------------------------------------");

        List<HumanDTO> humanDTOSfromStream = new ArrayList<>();
        humanDTOSfromStream = people.stream()
                .map(x -> new HumanDTO(x.getName(), x.getSurname()))
                .collect(Collectors.toList());
        humanDTOSfromStream.forEach(x-> System.out.println(x.getHumanData()));
        System.out.println("---------------------------------------------------");

        List<Human> newCommonHumnkind = new ArrayList<>();
        newCommonHumnkind.addAll(mans);
        newCommonHumnkind.addAll(woman);
       newCommonHumnkind.forEach(System.out::println);
        System.out.println("---------------------------------------------------");

        //Stream.of robi strumien z podanych elementow
        //po wyjsciu mamy strumien 2 elementow, elementy to listy
        //flatMap robi z dwoch elementow nowy strumien ludzi
        //flatMap robi z list ludzi strumien ludzi
        List<Human> newFromStreamHumankind = new ArrayList<>();
        newFromStreamHumankind = Stream.of(mans,woman)
                .flatMap(a->a.stream())
                .collect(Collectors.toList());
        newFromStreamHumankind.forEach(System.out::println);


    }
}
