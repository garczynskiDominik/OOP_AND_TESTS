package edu.domgie.sda.multithreading.basics;

import javax.swing.table.TableRowSorter;

import static edu.domgie.sda.multithreading.basics.ThreadColor.*;

public class MainThreading {
    public static void main(String[] args) {
        //kolenosc dzialania watkow jest losowa
        System.out.println(ANSI_PURPLE + "Main thread in action!");

        OtherThread otherThread = new OtherThread();
        otherThread.setName("nowy fajny watek");
/**
 *start powoluje nowy watek zapewnia zasoby czasu procesora i pamiec.
 *jak wszystko jest gotowe to uruchamia run juz w osobnym watku
 *metoda start() nie powinna zawierac kodu uzytkowanika
 */
        //uruchomienie nowego watku zawsze metoda start
        otherThread.start();

/**
 metoda run zawiera kod do wywyolania w osobnym watku, sam nie powoluje watku
 jesli zostanie wywolana bez osobnego watku to tez sie wykona
 */
        //  otherThread.run();


//uruchomienie watku z klasy implementujacej Runnable
        Thread runnableSample = new Thread(new RunnableSample());
        runnableSample.start();

        //Jednorazowy akcja do wykonania w osobnym watku - na klasie anonimowej

        /**
         klasa anonimowa to taka konstrukcja gdzie tworzymy nowy obiekt
         nie nadajac mu nazwy- czyli obiek jes i dziala ale
         nie mozna sie do niego pozniej odniesc,
         nie da sie znalezc wiec jest na jednorazowa akcje
         */
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Anonymous class can run thread too");
            }
        }.start();
        //Przerwanie watku
        //otherThread.interrupt();

//łączenie watków metoda join();
        //nadpiszemy(jednorazowo) istniejacy kod RunnableSample
        runnableSample = new Thread(new RunnableSample() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + " Overwritten RunnableSample working");
                try {
                    /**
                     *join() powoduje ze runnableSample zatrzymuje sie i czeka
                     * az otherThread skonczy swoje dzialanie i dopiero pozniej kontynuuje
                     *
                     * przyklad z generowaniem raportu do pliku:
                     * runnable zapisuje do plikku naglowek i dane, naglowek jest znany
                     * a dane sa obliczane przez otherThread
                     * runnableSample robi plik i zapisuje nagłowek i czeka az dostanie dane z otherThread
                     * zeby uzupelnic plik jak juz ma dane to kontynuuje zapisywanie
                     */
                    otherThread.join(2000);
                    System.out.println(ANSI_RED+"Overwritten RunnableSample working as OtherThread finished");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED + "INTERRUPTED Overwritten Runnable");
                }
            }
        });
        runnableSample.start();
        /**
         * runnableSample.interrupt() powoduje ze nie czekamy na zakonczenie oTherThread
         * tylko kontynuujemy dzialanie naszego watku runnableSample
         *
         * jednoczesnie nie przerywa to dzialania watku otherThread on sobie dziala,
         * tyle ze juz na niego nie czekamy
         */
        runnableSample.interrupt();
        System.out.println(ANSI_PURPLE + "End of main thread");
    }
}
