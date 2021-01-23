package edu.domgie.sda.java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    public static void main(String[] args) {
        /**
         * Zasada dzialania strumieni= wszystko plynie, czyli nie da sie drugi raz wejsc do tego samego strumienia
         *
         *
         * 1. Metody dzialajace na strumieniach dzielimy na 3 grupy musi wystapic jedna
         * -stream() na kolekcjach
         * -of() na elementach wyliczeniowych
         * -Arrays,stream(Object[]) na elementach tabeli
         * - na danych z pliku
         * - ... z kazda kolejna java pojawia sie cos nowego
         *
         *
         * 2. Metody posrednie- mozna laczyc, nie musi wystapic
         * -map przeksztalca element strumienia w inny (Human->String, String->String
         * flatMao - splaszczajaca elementy z kilku strumieni do jednego
         * filter- filtruje emelenty strumienia
         * limit - ogranicza ilosc elementow dalszego rpzetwarzania
         * sorted- sortuje wg domyslnego lub wskazanego komparatora
         * distinct- wybierajaca elementy niepowtarzalne
         *
         *
         * 3. Metody konczace strumien- musi wystapic jedna
         * toArray- tworzy tablice z elementow strumienia
         * collect- tworzy kolekcje z elementow strumeiinia
         * reduce - zwraca jedna wartosc wg wskazanego emmchanizmu
         * count- zwraca ilosc elementow
         * findFirst- zwraca  optionala od pierwszego znalezionego obiektu<Optional<Object>
         * findAny zwraca optionala od dowolnego znalezionego obiektu(ktory spelnia kryteria
         * foreach nic nie zwraca, wykonuje dzialanie na elementach strumienia
         */


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
        ArrayList<Human> people = new ArrayList<>();

        //3 obiekty z pierwszego konstruktora gdzie deklaruje enum
        people.add(new Human("Dominik", "Garczynski", 18, Gender.MAN));
        people.add(new Human("Natalia", "Starenga", 28, Gender.WOMAN));
        people.add(new Human("Wojtek", "Kowalsky", 50, Gender.MAN));

        //3 obiekty z drugiego konstruktora gdzie podajemy skrot płci
        people.add(new Human("Agata", "Pachel", 43, "K"));
        people.add(new Human("Marek", "Garczynski", 12, "M"));
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
        humanDTOSfromStream.forEach(x -> System.out.println(x.getHumanData()));

        //robienie jednej listy z dwoch
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
        newFromStreamHumankind = Stream.of(mans, woman)
                .flatMap(a -> a.stream())
                .collect(Collectors.toList());
        newFromStreamHumankind.forEach(System.out::println);

        //WAZNE  sumowanie wieku obiektów
        System.out.println("---------------------------------------------------");
        int sumOfAge = people.stream()
                .map(Human::getAge)
                .reduce(0, (suma, nowy) -> suma + nowy);
        System.out.println(sumOfAge);

        //zwraca jeden string laczacy wszystkie imiona
        System.out.println("---------------------------------------------------");
        String namesJoined = people.stream()
                .map(Human::getName)
                .collect(Collectors.joining());
        System.out.println(namesJoined);

        //zwracamy string laczacy wszystkie nazwiska
        System.out.println("---------------------------------------------------");
        String surnmanesJoined = people.stream()
                .map(Human::getSurname)
                .collect(Collectors.joining(", "));
        System.out.println(surnmanesJoined);

        //zwracamy sting laczacy wszystkie nazwiska z nawiasmi przed i po
        System.out.println("---------------------------------------------------");
        String surnamesJoinedJsonStyle = people.stream()
                .map(Human::getSurname)
                .collect(Collectors.joining(", ", "{", "}"));

        System.out.println(surnamesJoinedJsonStyle);

        // z listy robimy mape
        System.out.println("---------------------------------------------------");
        Map<String, Human> humanMaps = people.stream()
                .collect(Collectors.toMap(Human::getName, human -> human));

        humanMaps.keySet().stream()
                .map(x -> humanMaps.get(x))
                .forEach(System.out::println);

// grupowanie elementów, klucz to wartosc a value to ile takich wystapie
        System.out.println("---------------------------------------------------");
        Map<String, List<Human>> peopleGroupBySurname = new HashMap<>();
        peopleGroupBySurname=people.stream()
                .collect(Collectors.groupingBy(Human::getSurname,Collectors.toList()));
        peopleGroupBySurname.forEach((k,v)-> System.out.println(k+", "+v));
        System.out.println("---------------------------------------------------");

        List<Human> garczysnkiList = peopleGroupBySurname.entrySet()
                .stream()
                .filter(entry-> entry.getKey().equals("Garczynski"))
                .map(entry-> entry.getValue())
                //zwraca optional, jesli nie znajdzie to wykonuje orElseGet
                .findFirst()
                //wykona sie jesli  nie znajdzie sie wlasciwy obiekt
                .orElseGet(()->Collections.EMPTY_LIST);

        garczysnkiList.forEach(System.out::println);


    }



}
