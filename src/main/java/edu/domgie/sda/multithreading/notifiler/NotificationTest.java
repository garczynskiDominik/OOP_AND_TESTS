package edu.domgie.sda.multithreading.notifiler;

public class NotificationTest {
    public static void main(String[] args) {
        Message message = new Message();


        //przy watkach pamietamy ze nadpisujemy metode run()
        //ale watek uruchamiamy metoda start

        //kazdy z watkow ma wlasny stos pamieci
        //ale korzystaja ze wspolnej strefy pamieci

        /**
         * Na stosie odklada sie zmienne lokalne int,double,char[],short,long
         * na stercie odklada sie wszelkie obiekty w naszym przykladzie Message
         * Na stercie beda tez obiekty typu Integer, czyli wszystkie Wrappery na wartosci proste
         * Czyli obiekt klasy Message jest wspolny dla watkow Reader i Writer
         *
         *
         * String nie jest odkładany na wspólnej stercie
         * Ma on dedyokowany obszar pamięci zwany StringPool
         */

        //przy watkach pamietamu ze nadpisujemy metode run
        //ale watek uruchamiamy metoda start
        (new Thread(new Writer(message))).start(); // anonimowe wywolanie watku w klasie Writer


        //jawne wywoalnie
        Thread readerThread = new Thread(new Reader(message));
        readerThread.start();

        /**
         * Cykl zycia;
         * 1. Writert próbuje wykonac metode message.writter()
         * jesli w message nie ma innej wiadomosci czekajacej na obsluzenie
         * to zapisuje i powiadamia innych ze skonczyl
         * -jesli w message jest inna wiadomosc to czeka az ta poprzednia
         * wiadomosc zostanie obsluzona i wtedy zapisuje
         *
         * 2. Reader próbuje wykonac message.read()
         * -jesli w message nie ma wiadomosci do odczytania to czeka
         * az taka wiadomosc sie pojawi
         * -jesli w message jest wiadomosc to ja odczytuje i powiadamia innych
         * ze skonczyl a do obiektu message mozna wpisac kolejna wiadomosc
         * -jak wiadomosc  = "EOE" to reader konczy wszelkie odczyty
         */
    }
}
