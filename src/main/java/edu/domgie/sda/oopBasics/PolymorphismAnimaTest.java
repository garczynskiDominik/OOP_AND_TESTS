package edu.domgie.sda.oopBasics;

public class PolymorphismAnimaTest {

    public static void main(String[] args) {
        Bee bee = new Bee();
        bee.move();
        bee.hibernate();

        Penguin penguin = new Penguin();
        penguin.move();


        Animal polyBee = new Bee();
        polyBee.move();



        Animal polyPenguin = new Penguin();
        polyPenguin.move();
    }


}
