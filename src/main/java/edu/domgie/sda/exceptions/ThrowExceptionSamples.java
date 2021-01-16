package edu.domgie.sda.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowExceptionSamples {

    public void sleepThread() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void sleepThreadAndReadFile() throws InterruptedException, FileNotFoundException {
        Thread.sleep(5000);
        new FileReader("antyfile.ccc");
    }

    public void sleepAndReadFileOneException() throws FileNotFoundException, InterruptedException {
        Thread.sleep(5000);
        new FileReader("aaa.ccc");
    }

    public void sleepEx2() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void readFileEx2() throws FileNotFoundException {
        new FileReader("aaa");
    }

    public void sleepAndReadFileEx2() throws Exception {
        sleepEx2();
        readFileEx2();
    }

    public static void main(String[] args) {
        ThrowExceptionSamples throwExceptionSamples = new ThrowExceptionSamples();
        try {
            throwExceptionSamples.sleepAndReadFileEx2();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
