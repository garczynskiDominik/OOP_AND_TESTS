package edu.domgie.sda.multithreading.notifiler;

import java.util.Random;

import static edu.domgie.sda.multithreading.basics.ThreadColor.ANSI_PURPLE;

public class Reader implements  Runnable{
    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        //w petli czytamy kolejne wiadomosci z message.read()
        //dopoki nie wystapi wiadomosc "EOF"
        for (String lastetMessage = message.read(); lastetMessage!="EOF"; lastetMessage=message.read()) {
            //wypisujemy na ekran
            System.out.println(ANSI_PURPLE + "Odczytano wiadomosc:");
            System.out.println(ANSI_PURPLE+ lastetMessage);
            try{
                Thread.sleep(random.nextInt(4000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }
}
