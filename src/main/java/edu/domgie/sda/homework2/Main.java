package edu.domgie.sda.homework2;

public class Main {
    public static void main(String[] args) {
        Bank loyds = new Bank("Loyds Bank");
        // tworzenie nowych klientów
        Customer dominik = new Customer("Dominik", "Garczynski", 123456789);
        Customer natalia = new Customer("Natalia", "Starenga", 987654321);
        Customer pawel = new Customer("Pawel", "Wolos", 456789123);


        //dodanie klientow do banku
        loyds.addCustomerToBank(dominik);
        loyds.addCustomerToBank(natalia);
        loyds.addCustomerToBank(pawel);


        //dodanie rachunkow do klienta
        AcountClass loydsPersonalDominik = new AcountClass(TypeOfAccount.PERSONAL_ACCOUNT, 1000D, 271140204343535352L);
        AcountClass loydsSavingDominik = new AcountClass(TypeOfAccount.SAVINGS_ACCOUNT, 5000D, 1111111111155555555L);
        dominik.addAccountToList(loydsPersonalDominik);
        dominik.addAccountToList(loydsSavingDominik);

        //wpłada na rachunek Saving
        loydsSavingDominik.transferToAccount(2000D);
        //wyplata z rachunku Saving
        loydsSavingDominik.withDraw(6000);

        //dodanie rachunku do klienta
        AcountClass loydsSavingNatalia = new AcountClass(TypeOfAccount.SAVINGS_ACCOUNT, 2000D, 89561234569845321L);
        natalia.addAccountToList(loydsSavingNatalia);

        //dodanie rachunków do klienta
        AcountClass loydsSavingPawel = new AcountClass(TypeOfAccount.SAVINGS_ACCOUNT, 0, 123654789L);
        AcountClass loydsPersonalPawel = new AcountClass(TypeOfAccount.PERSONAL_ACCOUNT, 100D, 789654123987L);
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