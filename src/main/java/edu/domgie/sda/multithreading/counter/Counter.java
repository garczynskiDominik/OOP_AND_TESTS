package edu.domgie.sda.multithreading.counter;

import static edu.domgie.sda.multithreading.basics.ThreadColor.*;

public class Counter {
    private int i;

    /**
     * mozna synchronizowac cala "duza" metode ale to nie zalecane
     * bo powinnismy synchronizowac najmniejsze mozliwe niezbedne
     * kawalki kodu-metody, badz bloki kodu
     *
     * w performCountDown wykonuje sie wczesniej sporo innego kodu
     * ktory nie jest wrazliwy na zmie watku
     */
    // public synchronized void performCountDown() {
    public void performCountDown() {
        String color;
        switch (Thread.currentThread().getName()) {
            case "Thread1":
                color = ANSI_CYAN;
                break;
            case "Thread2":
                color = ANSI_PURPLE;
                break;
            default:
                color = ANSI_GREEN;
        }

        /**
         * kod zadeklarowany jako synchronized musi sie w calosci wykonc
         * dla jednego watku i dopiero pozniej inny watek moze zaczac
         * wykonywac ten sam kawalek kodu dla siebie
         */
        synchronized (this) {
            doRealCountDown(color);
        }
    }

    //private synchronized void doRealCountDown(String color) {
    private void doRealCountDown(String color) {
        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " i=" + i);
        }
    }
}
