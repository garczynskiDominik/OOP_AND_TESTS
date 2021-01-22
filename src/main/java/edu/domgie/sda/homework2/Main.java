package edu.domgie.sda.homework2;

public class Main {
    public static void main(String[] args) {
        Bank loyds = new Bank("Loyds Bank");

        Customer dominik = new Customer("Dominik", "Garczynski", 123456789);
        Customer natalia = new Customer("Natalia", "Starenga", 987654321);

        Account loydsPersonalDominik = new Account(TypeOfAccount.PERSONAL_ACCOUNT, 1000D, 271140204343535352L);
        Account loydsSavingDominik = new Account(TypeOfAccount.SAVINGS_ACCOUNT, 5000D, 1111111111155555555L);

        dominik.addAccountToList(loydsPersonalDominik);
        dominik.addAccountToList(loydsSavingDominik);

        Account loydsSavingNatalia = new Account(TypeOfAccount.SAVINGS_ACCOUNT, 2000D, 89561234569845321L);
        natalia.addAccountToList(loydsSavingNatalia);


        loyds.addCustomerToList(dominik);
        loyds.addCustomerToList(natalia);

        loyds.getListOfClients().forEach(System.out::println);





    }
}
//wypisanie klientów banku (z listą rachunków(w zależności od żądania z saldem lub bez))
//wypisanie rachunków podanego klienta (z saldem lub bez)
//wypisanie wszystkich rachunków w banku(z saldami lub bez)








//Napiszcie kod który będzie symulował bank, klientów, konta, operacje
//Minimum 3 klasy, w każdej wypisałem niezbędne pola, ale zakładam że trzeba więcej (np prywatnych)
//Bank: nazwa, lista klientów
//Customer: imie, nazwisko, unikalny numer klienta, lista rachunków
//Account: typ(ROR, oszczędnościowe), stan rachunku, unikalny numer rachunku
//operacje:

//założenie klienta !
//założenie rachunku dla klienta !
//usunięcie rachunku dla klienta (jeśli stan środków = 0)
//usunięcie klienta (jeśli nie ma rachunków)
//wpłata na rachunek
//wypłata z rachunku (do wysokości salda)
//wypisanie klientów banku (z listą rachunków(w zależności od żądania z saldem lub bez))
//wypisanie rachunków podanego klienta (z saldem lub bez)
//wypisanie wszystkich rachunków w banku(z saldami lub bez)