package edu.domgie.sda.multithreading.notifiler;

import java.util.Random;

public class Writer implements Runnable {
    private Message message;
    private String[] messageToWrite={"Linia1", "Linia2", "Linia3", "Linia4"};


    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < messageToWrite.length; i++) {
            message.write(messageToWrite[i]);
            try {
                Thread.sleep(random.nextInt(4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.write("EOF");
    }
}
