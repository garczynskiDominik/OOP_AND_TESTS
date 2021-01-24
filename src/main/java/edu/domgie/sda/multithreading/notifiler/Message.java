package edu.domgie.sda.multithreading.notifiler;

import static edu.domgie.sda.multithreading.basics.ThreadColor.*;

public class Message {
    private String messageContent;
    //messageEmpty jest znacznikiem ktory mowi czy do obiektu klasy Message
    //mozna aktualnie przekazac wiadomosc czy jakas wlasnie jest w trakcie
    private boolean messageEmpty = true;


    //odczytujemy wiadomosc
    //synchronized wiec odczytywac moze tylko 1 watek na raz
    public synchronized String read() {

        //dopoki nie ma nic do odczytu to czekaj
        //message empty musi zostac ustawione na false w metodzie write
        while (messageEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(ANSI_GREEN + "Bład odczytu");
            }
        }
        //jak tu doszlismy to znaczy ze messageEmpty jest rowne false
        ///czyli jest jakas wiadomosc
        System.out.println(ANSI_GREEN + "Odczytujemy wiadomosc");
        System.out.println(ANSI_GREEN + messageContent);

        //po odczytaniu wiadomosci, ustaw znacznik spowrotem na true
        messageEmpty = true;

        //notifyAll(); powiadamia wszelkie inne watli ze biezacy watek konczy dzialanie
        //wszelkie inne na ktorych metoda wait moga probowac dzialac

        notifyAll();
        //notify(); powoduje powiadomienie jednego watku ktory jest w trakcie wait
        //losowy watek z czekajacych
        return messageContent;
    }
//synchronized czyli 1 watek na raz moze ta metode wykonac
    public synchronized void write(String newMessage) {
        //jesli  znacznik mowi ze jest jakas wiadomosc to nie mozna wpisac nowej
        //i trzeba czekac na notify()/notifyAll() z innego watku
        while (!messageEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(ANSI_BLUE + "Blad zapisu");
            }
        }
        //ktos zrobil notify/notifyAll wiec wpisuje nowa wiadomosc
        System.out.println(ANSI_BLUE + "Nowa wiadomosc zapisana");
        System.out.println(ANSI_BLUE + newMessage);
        //ustawiamy znacznik ze nowa wiadomosc wpisana i nalezy ja obsluzyc
        messageEmpty = false;
        messageContent = newMessage;
        //powiadamiamy inne watki ze metoda write konczy dzialanie
        notifyAll();
    }

}
