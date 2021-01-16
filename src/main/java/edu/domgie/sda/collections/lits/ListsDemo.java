package edu.domgie.sda.collections.lits;

import edu.domgie.sda.collections.CollectionsCar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsDemo {
    public static void main(String[] args) {


        CollectionsCar car1 = new CollectionsCar("Vw", "1.9", 120);
        CollectionsCar car2 = new CollectionsCar("bmw", "2.9", 110);
        CollectionsCar car3 = new CollectionsCar("fiat", "1.5", 190);
        CollectionsCar car4 = new CollectionsCar("opel", "1.1", 170);


        List<CollectionsCar> oldList = new ArrayList<>();
        List<CollectionsCar> carArrayList = new ArrayList<>();

        carArrayList.add(car1);
        carArrayList.add(car2);
        carArrayList.add(car3);
        carArrayList.add(car4);


        carArrayList.forEach(el-> System.out.println(el));

        List<CollectionsCar> linkedList = new LinkedList<>();
        linkedList.add(car1);
        linkedList.add(car4);
        linkedList.add(car2);
        linkedList.add(car3);
        linkedList.add(car4);
        linkedList.add(car1);

        System.out.println();
        linkedList.forEach(el-> System.out.println(el));
        System.out.println();

        for (CollectionsCar collectionsCar : linkedList) {
            System.out.println(collectionsCar);

        }
    }
}


