package edu.domgie.sda.multithreading.basics;

import static edu.domgie.sda.multithreading.basics.ThreadColor.ANSI_RED;

public class RunnableSample implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Runnable sample working as well");
    }
}
