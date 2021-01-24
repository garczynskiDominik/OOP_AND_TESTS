package edu.domgie.sda.io.basics;

import java.io.*;
import java.util.Scanner;

public class ReadWriteFile {
    public static void main(String[] args) {
        String firstFile = "FirstFile.txt";
        String secondFile = "SecondFile.txt";
        ReadWriteFile readWriteFile = new ReadWriteFile();
        //FileReader i FileWriter mozna uzywac do zapisywania i odczytywania niewielkich plikow
        // max do np. 1000 lini
        //bo one dzialaja w tym samym watku co glowny program
        //wiec moga zablokowac mozliwosc koszystania z innych opcji
        //dodatkowo wykonuja bezposrednia operacje
        readWriteFile.simpleEditWriterToFile(firstFile, true);
        readWriteFile.simpleReaderFromFile("FirstFile.txt");
        System.out.println("---------------------------------");
        readWriteFile.writerEditFileWithBuffer(secondFile, true);
        readWriteFile.readerFileWithBuffer("SecondFile.txt");
    }

    //dopisywanie do pliku
    public void simpleEditWriterToFile(String filename, boolean append) {
        //try-with-resourcers
        //wprowadzone w Javie
        //FileWriter czyli zapisywacz do pliku- dostepny od poczatku javy
        // do try-with-resources mozna wrzucic obiekty klas
        //ktore spelniaja interfejs AutoClosable albo Closable
        try (FileWriter write = new FileWriter(filename, append)) {
            System.out.println("Zapisujemy do pliku: " + filename);
            //writer.writer realizuje zapis do pliku
            write.write("Linia pierwsza\n");
            write.write("Linia druga\n");
            write.write("Linia trzecia");

            //try-with-resources sam zadba o wywolanie metody writer
        } catch (IOException e) {
            System.out.println("Blad przy zapisie");
        }
        System.out.println("Koniec zapisywanie do pliku");
    }

    public void simpleReaderFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scanner = new Scanner(fileReader);
            //okreslamy jaki znak konca lini
            scanner.useDelimiter("\n");
            System.out.println("Reading from file " + fileName);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
            // poniewaz nie mamy tu try-with-resources to musimy sami zamknac zasoby
            scanner.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Koniec odczytywania pliku");
    }
// metoda do dopisywania do pliku
    public void writerEditFileWithBuffer(String filename, boolean append) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, append));
            /**
             * BufferWriter powoduje ze zapis nastepuje najpierw do miejsca
             * w pamieci i zwanego buforem a dopiero jak bufor sie przepelni
             * (albo wszystko zostanie zapisane)
             * to nastepuje wiekszy zapis do pliku
             * duzej ilosci danyc a nie znak po znaku
             */
            writer.write("Buffered First Line\n");
            writer.write("Buffered Second Line\n");
            writer.write("Buffered Third Line\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Blad zapisu pliku");
        }
        System.out.println("Koniex zapisu do pliku z Bufferem");

    }

    public void readerFileWithBuffer(String fileName) {
        String input;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((input = reader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Pliku nie znaleziono");
        } catch (IOException e) {
            System.out.println("Inny blad IO");
        }
        System.out.println("Koniec odczytu z pliku z buforowaniem");
    }
}
