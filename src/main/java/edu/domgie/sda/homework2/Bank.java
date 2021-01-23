package edu.domgie.sda.homework2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank {

    class AccountWithoutBalance {
        private String firstName;
        private String lastName;
        private int idNumber;
        private List<Acount> listOfAccounts;

        public AccountWithoutBalance(String firstName, String lastName, int idNumber, List<Acount> listOfAccounts) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.idNumber = idNumber;
            this.listOfAccounts = listOfAccounts;
        }

    }


    private String nameBank;
    private List<Customer> listOfClients;

    public Bank(String nameBank) {
        this.nameBank = nameBank;
        this.listOfClients = new ArrayList();
    }

    //założenie klienta
    public void addCustomerToBank(Customer customer) {
        listOfClients.add(customer);
    }

    //usunięcie klienta (jeśli nie ma rachunków)
    public void removerCustomerIfDontHaveAccounts(Customer customer) {
        if (customer.getListOfAccounts().size() == 0) {
            listOfClients.remove(customer);
        }
    }

    //wypisanie klientów banku (z listą rachunków(w zależności od żądania z saldem lub bez))
    public void showCustomersAccountsWithSaldo() {
        listOfClients.forEach(System.out::println);
    }

//    public void showCustomersAccountsWithoutSaldo() {
//        listOfClients.stream().
//    }


    //wypisanie wszystkich rachunków w banku(z saldami lub bez)
    public void showAllAccountsFromBankWithSaldo() {
        listOfClients.forEach(client -> System.out.println(client.getListOfAccounts()));
    }

//    public void showAllAccountsFromBankWithoutSaldo() {
//        for (Customer client : listOfClients) {
//            System.out.println(client.getListOfAccounts());
//        }
//    }

}
