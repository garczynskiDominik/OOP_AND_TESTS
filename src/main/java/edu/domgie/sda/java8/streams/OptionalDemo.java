package edu.domgie.sda.java8.streams;

import java.util.ArrayList;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        ArrayList<Human> people = new ArrayList<>();

        //3 obiekty z pierwszego konstruktora gdzie deklaruje enum
        people.add(new Human("Dominik", "Garczynski", 18, Gender.MAN));
        people.add(new Human("Natalia", "Starenga", 28, Gender.WOMAN));
        people.add(new Human("Wojtek", "Kowalsky", 50, Gender.MAN));


        Human human = new Human("d","s",2,Gender.MAN);

        //3 obiekty z drugiego konstruktora gdzie podajemy skrot płci
        people.add(new Human("Agata", "Pachel", 43, "K"));
        people.add(new Human("Marek", "Garczynski", 12, "M"));
        people.add(new Human("Zosia", "Wisniewska", 34, "K"));

        String findTrump = people.stream()
                .filter(check -> "Trump".equalsIgnoreCase(check.getSurname()))
                .map(Human::getSurname)
                .findAny()
                .orElse("Nie znam czlowieka");
        System.out.println(findTrump);


        Optional<String> findLechu = people.stream()
                .filter(check -> "Lechu".equalsIgnoreCase(check.getName()))
                .map(Human::getName)
                .findFirst();

        if (findLechu.isPresent()) {
            System.out.println("Lechu ?: " + findLechu.get());
        } else {
            System.out.println("Lecha nie ma");
        }
        Human filteredHuman = people.stream()
                .filter(a -> "Marcin".equals(a.getName()))
                .findFirst()
                //jak mmay metode orElse jest slabszym rozwiazaniem
                //bo zawartosc metody wykona sie zawsze niezaleznie czy trzeba czy nie
                .orElse(getDefaultHuman("N", "N", 0, "M"));
        System.out.println(filteredHuman);

        Human anotherFilter = people.stream()
                .filter(c -> c.getName().equals("Marcin"))
                .findFirst()
                //jak mamy metode to orElseGet jest preferowane
                //bbo zawartosc metody wykona sie tylko jesli bedzie to niezbedne
                .orElseGet(() -> getDefaultHuman("N", "N", 0, "M"));
        System.out.println(anotherFilter);
    }

    private static Human getDefaultHuman(String name, String surname, int age, String gender) {
        System.out.println("Jestem w metodzie dorabiajacej domyslnego czlowieka");
        return new Human(name, surname, age, gender);
    }
}
