package edu.domgie.sda.java8.streams;

import java.util.Comparator;

public class HumanComparedByName implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human humna2) {
        return human1.getName().compareTo(humna2.getName());
    }
}
