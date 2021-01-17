package edu.domgie.sda.multithreading.basics;

import static edu.domgie.sda.multithreading.basics.ThreadColor.ANSI_BLUE;

public class OtherThread extends Thread{
    @Override
    public void run() {
        super.run();
        //tu dajemy kod do wywolania w sobnym watku

        System.out.println(ANSI_BLUE + "Other thread in action");
        System.out.println(ANSI_BLUE + currentThread().getName());

       try {
           sleep(4000);
           System.out.println(ANSI_BLUE+"Enough sleep , back to work");
       }catch (InterruptedException e){
           System.out.println(ANSI_BLUE+"I couldn't sleep enough, interruped");
       }
    }
}
