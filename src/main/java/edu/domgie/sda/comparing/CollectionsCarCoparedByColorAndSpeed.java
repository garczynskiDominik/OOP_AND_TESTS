package edu.domgie.sda.comparing;

import edu.domgie.sda.collections.CollectionsCar;

import java.util.Comparator;

public class CollectionsCarCoparedByColorAndSpeed implements Comparator<CollectionsCar> {

    @Override
    public int compare(CollectionsCar car1, CollectionsCar car2) {
        if (car1.getColor().compareTo(car2.getColor())!=0){
            return car1.getColor().compareTo(car2.getColor());
        }
        if (car1.getMaxSpeed().compareTo(car2.getMaxSpeed()) != 0){
            return car1.getMaxSpeed().compareTo(car2.getMaxSpeed());
        }
        return 0;
    }
}
