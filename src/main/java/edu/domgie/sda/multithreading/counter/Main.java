package edu.domgie.sda.multithreading.counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
      //  Counter counter2 = new Counter();
/**
 * jesli watki korzystaja z wspolnych obiektow counter
 * to potrzebuja synchronizacji
 *
 * jesli mamy dwa obiekty counter i do dwoch threadCounter przekazemy
 * 2 countery to nie ma co synchronizowac
 */
        ThreadCounter threadCounter1 = new ThreadCounter(counter);
        ThreadCounter threadCounter2 = new ThreadCounter(counter);
        threadCounter1.setName("Thread1");
        threadCounter1.setName("Thread2");

        threadCounter1.start();
        threadCounter2.start();
    }
}
