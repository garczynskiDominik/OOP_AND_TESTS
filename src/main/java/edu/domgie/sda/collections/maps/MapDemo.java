package edu.domgie.sda.collections.maps;

import edu.domgie.sda.collections.CollectionsCar;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        CollectionsCar car1 = new CollectionsCar("Vw", "1.9", 120);
        CollectionsCar car2 = new CollectionsCar("bmw", "2.9", 110);
        CollectionsCar car3 = new CollectionsCar("fiat", "1.5", 190);
        CollectionsCar car4 = new CollectionsCar("opel", "1.1", 170);


        Map<String, CollectionsCar> mapOfCarsByName = new HashMap<>();
        mapOfCarsByName.put(car1.getName(), car1);
        mapOfCarsByName.put(car1.getName(), car1);
        mapOfCarsByName.put("Other", car1);
        mapOfCarsByName.put(car2.getName(), car2);
        mapOfCarsByName.put(car3.getName(), car3);
        mapOfCarsByName.put(car4.getName(), car4);


        for (CollectionsCar car : mapOfCarsByName.values()) {
            System.out.println(car);
        }
        System.out.println();
        for (String key : mapOfCarsByName.keySet()) {
            System.out.println(key);
        }
//        mapOfCarsByName.forEach((k,v)-> System.out.println(k +"="+v));
        for (Map.Entry<String, CollectionsCar> stringCollectionsCarEntry : mapOfCarsByName.entrySet()) {
            System.out.println(stringCollectionsCarEntry.getKey()+ "==========" + stringCollectionsCarEntry.getValue());
        }
        System.out.println();

        mapOfCarsByName.remove("Other",car2);

        for (String key : mapOfCarsByName.keySet()) {
            System.out.println(mapOfCarsByName.get(key));
        }




    }
}
