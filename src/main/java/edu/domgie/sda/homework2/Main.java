package edu.domgie.sda.homework2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {


        Bank loyds = new Bank("Loyds Bank");

        loyds.createNewCustomer("Tomek", "Kozak");
        loyds.createNewCustomer("Damian", "Kozik");
        loyds.createNewCustomer("Krystian", "Malek");
        loyds.createNewCustomer("Andrzej", "Mazur");

        loyds.addAccountToCustomerList("Tomek", "Kozak","SN");
        loyds.addAccountToCustomerList("Tomek", "Kozak", "PN");
        loyds.addAccountToCustomerList("Damian", "Kozik", "SN");
        loyds.addAccountToCustomerList("Krystian", "Malek", "PN");


        loyds.isDeposit("Tomek", "Kozak", "PN", new BigDecimal(25));
        loyds.withDraw("Tomek", "Kozak", "PN", new BigDecimal(15));

        loyds.isDeposit("Krystian", "Malek", "SN", new BigDecimal(2445));


       loyds.removeCustomerWihoutAccountsFromBank("Andrzej", "Mazur");


        System.out.println("----------All Customers accounts with baalance-----------");
        //wyswietlenie uzytkowników z lista rachunkow z saldem
        loyds.showCustomersAccountsWithBalance(true);

        System.out.println("\n----------All Customers accounts without balance-----------");
        //wyswietlenie uzytkownikow z lista rachunkow bez salda
        loyds.showCustomersAccountsWithBalance(false);

        System.out.println("\n-----------Customer account with balance----------");
        //wyswietlenie rachunkow uzytkownika z saldem
        loyds.showAccountOneCustomer("Tomek", "Kozak", true);


        System.out.println("\n----------Customer accounts without balance-----------");
        //wyswietlanie rachunkow uzytkownika bez salda
        loyds.showAccountOneCustomer("Tomek", "Kozak", false);


        System.out.println("\n-----------All accounts in bank with balance----------");
        //wyswietlenie rachunkow w banku z saldem
        loyds.showAllAccountsFromBankWithBalance(true);


        System.out.println("\n----------All accounts in bank without balance------------");
        // wyswietlanie rachunkow w banku bez salda
        loyds.showAllAccountsFromBankWithBalance(false);


    }
}


//+big decimal,+w petli do,+