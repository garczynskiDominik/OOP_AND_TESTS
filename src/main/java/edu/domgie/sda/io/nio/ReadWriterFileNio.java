package edu.domgie.sda.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ReadWriterFileNio {
    /**
     * NIO uzywa wielowatkowosci
     * pozwala na operacje na plikach w tle
     * z jednoczesnym relizowaniem innych operacji
     */
    public static void main(String[] args) {
        String filename= "NioFile.txt";
        ReadWriterFileNio readWriterFileNio = new ReadWriterFileNio();

        try{
            readWriterFileNio.simpleWriterToFile(filename);
            readWriterFileNio.simpleReaderFromFile(filename);
        } catch (IOException e){
            System.out.println("Blad");
        }
    }

    public void simpleWriterToFile(String filename) throws IOException {
        Files.writeString(Paths.get(filename), "FirstLine\n");
        Files.writeString(Paths.get(filename), "SecondLine\n", StandardOpenOption.APPEND);
        Files.writeString(Paths.get(filename), "ThirdLine", StandardOpenOption.APPEND);
    }

    public void simpleReaderFromFile(String filename) throws IOException {
        List<String> fileconntent;
        fileconntent = Files.readAllLines(Paths.get(filename));
        fileconntent.forEach(System.out::println);
    }
}
