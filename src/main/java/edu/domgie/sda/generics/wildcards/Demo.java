package edu.domgie.sda.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Image image1 = new Image("Obraz 1");
        Image image2 = new Image("Obraz 2");

        Memento memento1 = new Memento(new Note("Pamiatka z wakacji"));
        Memento memento2 = new Memento(new Note("Pamiatka z ferii"));
        Picture picture1 = new Picture(new Note("fota z nad morza"),image1);
        Picture picture2= new Picture(new Note("fota z gor"),image2);


        List<Memento> memoris = new ArrayList<>();
        memoris.add(memento1);
        memoris.add(memento2);
        memoris.add(picture1);
        memoris.add(picture2);


        MemoriesServer<Memento> album = new MemoriesServer<>();
        album.printAllMemories(memoris);
        System.out.println("--------------------------------------------");
        album.addAllMemories(memoris);
        album.printInternalMemories();
        System.out.println("--------------------------------------------");
        List<Picture> picturesOnly = new ArrayList<>();
        picturesOnly.add(picture1);
        picturesOnly.add(picture2);
        /**
         * wywolanie printAllMemories dla picture Only nie zadziała
         * bo JVM spodziewa sie listy List<Memento>
         *     a dostaje List<Picture>
         * i momo ze Picture jest klasa pochodna od Memento to nie umie tego obslugiwac
         * bo List<Picture> nie jest klasa pochodna od List<Memento>
         *
         *     czyli nawet jak klasa B rozszerza klase A
         *     to kolekcha B nie rozszerza kolekcji A
         *
         *     i do tego wlasnie potrzebny jest operator wild czyli ? (pytajnik * typ nie okreslony)
         *
         *
         */
        //nie zadziala bo  spodziewa sie listy
        //album.printInternalMemories(picturesOnly);
        System.out.println("---------------------tylko obrazkowe pamiatki-----------------------");
        album.printWildcardAllMemories(picturesOnly);
        System.out.println("------------------drukujemy wszystkie pamiatki--------------------------");
        album.printWildcardAllMemories(memoris);
        System.out.println("--------------------------------------------");
    }
}
