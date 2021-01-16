package edu.domgie.sda.comparing;

import edu.domgie.sda.collections.CollectionsCar;

import java.util.Comparator;

public class CollectionsCarCompareBySpeed implements Comparator<CollectionsCar> {

    @Override
    public int compare(CollectionsCar car1, CollectionsCar car2) {
//        return car1.getMaxSpeed().compareTo(car2.getMaxSpeed());

        if (car1.getMaxSpeed() < car2.getMaxSpeed()){
            return -1;
        }
        if (car1.getMaxSpeed() > car2.getMaxSpeed()){
            return 1;
        }
        return 0;
    }
}
