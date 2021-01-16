package edu.domgie.sda.comparing;

import edu.domgie.sda.collections.CollectionsCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparingDemo {
    public static void main(String[] args) {
        CollectionsCar car1 = new CollectionsCar("vw", "1.9", 120);
        CollectionsCar car2 = new CollectionsCar("bmw", "2.9", 110);
        CollectionsCar car3 = new CollectionsCar("fiat", "1.5", 190);
        CollectionsCar car4 = new CollectionsCar("opel", "1.1", 170);

        car1.setColor("Czarne");
        car2.setColor("Zielony");
        car3.setColor("Czarne");
        car4.setColor("Czerwone");

        List<CollectionsCar> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);


        System.out.println("pierwsze wersja jak weszlu");
        carList.forEach(el -> System.out.println(el));
        System.out.println("Posortowane");
        Collections.sort(carList);
        carList.forEach(el -> System.out.println(el));

        Collections.sort(carList, new CollectionsCarCompareBySpeed());

        System.out.println("pierwsze wersja jak weszlu");
        carList.forEach(el -> System.out.println(el));
        System.out.println("Posortowane");
        Collections.sort(carList);
        carList.forEach(el -> System.out.println(el));

        Collections.sort(carList, new CollectionsCarCompareBySpeed());

        System.out.println();
        Collections.sort(carList, Collections.reverseOrder());
        carList.forEach(el -> System.out.println(el));


        Collections.sort(carList, new CollectionsCarCompareBySpeed().reversed());

        System.out.println();
        Collections.sort(carList, Collections.reverseOrder());
        carList.forEach(el -> System.out.println(el));

        System.out.println();
        Collections.sort(carList, new CollectionsCarCoparedByColorAndSpeed().reversed());

        carList.forEach(el-> System.out.println(el));

    }
}
