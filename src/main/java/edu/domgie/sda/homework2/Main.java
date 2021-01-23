package edu.domgie.sda.homework2;

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


        System.out.println("----------All Customers accounts with baalance-----------");
        //wyswietlenie uzytkowników z lista rachunkow z saldem
        loyds.showCustomersAccountsWithBalance(true);

        System.out.println("\n----------All Customers accounts without balance-----------");
        //wyswietlenie uzytkownikow z lista rachunkow bez salda
        loyds.showCustomersAccountsWithBalance(false);

        System.out.println("\n-----------Customer account with balance----------");
        //wyswietlenie rachunkow uzytkownika z saldem
        dominik.showAccountsOfCustomerWithBalance(true);


        System.out.println("\n----------Customer accounts without balance-----------");
        //wyswietlanie rachunkow uzytkownika bez salda
        dominik.showAccountsOfCustomerWithBalance(false);



        System.out.println("\n-----------All accounts in bank with balance----------");
        //wyswietlenie rachunkow w banku z saldem
        loyds.showAllAccountsFromBankWithBalance(true);



        System.out.println("\n----------All accounts in bank without balance------------");
        // wyswietlanie rachunkow w banku bez salda
        loyds.showAllAccountsFromBankWithBalance(false);




    }
}








//wypisanie klientów banku (z listą rachunków(w zależności od żądania z saldem lub bez))
//wypisanie rachunków podanego klienta (z saldem lub bez)
//wypisanie wszystkich rachunków w banku(z saldami lub bez)