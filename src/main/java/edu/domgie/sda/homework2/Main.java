package edu.domgie.sda.homework2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bank loyds = new Bank("Loyds Bank");
        // tworzenie nowych klientów
        Customer dominik = new Customer("Dominik", "Garczynski");
        Customer natalia = new Customer("Natalia", "Starenga");
        Customer pawel = new Customer("Pawel", "Wolos");


        //dodanie klientow do banku
        loyds.addCustomerToBank(dominik);
        loyds.addCustomerToBank(natalia);
        loyds.addCustomerToBank(pawel);


        //dodanie rachunkow do klienta
        Acount loydsPersonalDominik = new Acount(TypeOfAccount.PERSONAL_ACCOUNT);
        Acount loydsSavingDominik = new Acount(TypeOfAccount.SAVINGS_ACCOUNT);
        dominik.addAccountToList(loydsPersonalDominik);
        dominik.addAccountToList(loydsSavingDominik);

        //wpłada na rachunek Saving
        loydsSavingDominik.isdepositComplete(2000D);
        //wyplata z rachunku Saving
        loydsSavingDominik.withDraw(6000);

        //dodanie rachunku do klienta
        Acount loydsSavingNatalia = new Acount(TypeOfAccount.SAVINGS_ACCOUNT);
        natalia.addAccountToList(loydsSavingNatalia);
        //wplata na rachunek oszczednosciowy
        loydsSavingNatalia.isdepositComplete(1590);

        //dodanie rachunków do klienta
        Acount loydsSavingPawel = new Acount(TypeOfAccount.SAVINGS_ACCOUNT);
        Acount loydsPersonalPawel = new Acount(TypeOfAccount.PERSONAL_ACCOUNT);
        pawel.addAccountToList(loydsPersonalPawel);
        pawel.addAccountToList(loydsSavingPawel);

        //usuwanie rachunku ktorego saldo wynosi 0
        pawel.removeAccountFromCustomerListIFSaldo0(loydsPersonalPawel);

        //usuwanie klienta ktory nie ma rachunku
        loyds.removerCustomerIfDontHaveAccounts(pawel);
        loyds.removerCustomerIfDontHaveAccounts(dominik);

        //wyswietlenie uzytkowników z lista rachunkow z saldem
        loyds.showCustomersAccountsWithSaldo();
        System.out.println("---------------------");
        //wyswietlenie rachunkow uzytkownika z saldem
        dominik.showAccountsOfCustomerWithSaldo();
        System.out.println("---------------------");
        dominik.showAccountsOfCustomerWithoutSaldo();
        System.out.println("---------------------");
        //wyswietlenie rachunkow w banku z saldem
        loyds.showAllAccountsFromBankWithSaldo();
        System.out.println("----------------------");


    }
}


//założenie klienta !
//założenie rachunku dla klienta !
//usunięcie rachunku dla klienta (jeśli stan środków = 0)
//usunięcie klienta (jeśli nie ma rachunków)
//wpłata na rachunek
//wypłata z rachunku (do wysokości salda)
//wypisanie klientów banku (z listą rachunków(w zależności od żądania z saldem lub bez))
//wypisanie rachunków podanego klienta (z saldem lub bez)
//wypisanie wszystkich rachunków w banku(z saldami lub bez)