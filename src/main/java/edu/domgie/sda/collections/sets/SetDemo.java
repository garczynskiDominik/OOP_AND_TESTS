package edu.domgie.sda.collections.sets;

import edu.domgie.sda.collections.CollectionsCar;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        CollectionsCar car1 = new CollectionsCar("Vw", "1.9", 120);
        CollectionsCar car2 = new CollectionsCar("bmw", "2.9", 110);
        CollectionsCar car3 = new CollectionsCar("fiat", "1.5", 190);
        CollectionsCar car4 = new CollectionsCar("opel", "1.1", 170);


        Set<CollectionsCar> setOfCars = new HashSet<>();
        setOfCars.add(car1);
        setOfCars.add(car2);
        setOfCars.add(car3);
        setOfCars.add(car4);
        setOfCars.add(car2);
        setOfCars.add(car3);
        setOfCars.add(car1);


        setOfCars.forEach(el-> System.out.println(el));
        Set<CollectionsCar> linkedSet = new LinkedHashSet<>();
        linkedSet.add(car1);
        linkedSet.add(car2);
        linkedSet.add(car3);
        linkedSet.add(car4);
        linkedSet.add(car1);

        linkedSet.forEach(el-> System.out.println(el));



        Set<CollectionsCar> sortedSet = new TreeSet<>();
        sortedSet.addAll(linkedSet);
        System.out.println("posortowany po silniku");


        sortedSet.forEach(el-> System.out.println(el));
    }


}
