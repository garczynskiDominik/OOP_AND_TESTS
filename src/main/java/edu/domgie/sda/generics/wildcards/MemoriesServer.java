package edu.domgie.sda.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class MemoriesServer <T extends Memento>{

    List<T> internalMemories = new ArrayList<>();
    public void printAllMemories(List<T> memories){
        System.out.println("Reviewing mem");
        memories.forEach(x-> System.out.println(x.getInfo()));
    }
    public void addAllMemories(List<T> memories){
        internalMemories.addAll(memories);
    }

    public void printInternalMemories(){
        System.out.println("Printing inter mem");
        printAllMemories(internalMemories);
    }
    //oznacza Memento lub dowolna klase dziedziczaca z Memento
    public void printWildcardAllMemories(List<? extends Memento> memories){
        System.out.println("Reviewing all possible memoriers: ");
        memories.forEach(x-> System.out.println(x.getInfo()));
    }
}
