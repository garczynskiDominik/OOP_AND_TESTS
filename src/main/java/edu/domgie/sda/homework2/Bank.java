package edu.domgie.sda.homework2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private NumberFormat formatter = new DecimalFormat("#000");
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
    public void showCustomersAccountsWithBalance(boolean withBalance) {
        listOfClients
                .forEach(client-> System.out.println(client.getFirstName()+", "+client.getLastName()+", ID: "+formatter.format(client.getIdNumber())+", "+client.getAccount(withBalance)));
    }

    //wypisanie wszystkich rachunków w banku(z saldami lub bez)
    public void showAllAccountsFromBankWithBalance(boolean withBalance) {
        listOfClients.forEach(client -> client.getListOfAccounts().stream().forEach(x-> System.out.println(x.getAccountInformation(withBalance))));
    }
}
