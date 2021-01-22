package edu.domgie.sda.homework2;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String nameBank;
    private List listOfClients;

    public Bank(String nameBank) {
        this.nameBank = nameBank;
        this.listOfClients = new ArrayList();
    }

    public void addCustomerToList(Customer customer) {
        listOfClients.add(customer);
    }

    public void removerCustomer(Customer customer) {
        if (customer.getListOfAccounts().size() == 0) {
            listOfClients.remove(customer);
        }
    }

    public List getListOfClients() {
        return listOfClients;
    }


    //operacje:

//założenie klienta
//założenie rachunku dla klienta
//usunięcie rachunku dla klienta (jeśli stan środków = 0)
//usunięcie klienta (jeśli nie ma rachunków)
//wpłata na rachunek
//wypłata z rachunku (do wysokości salda)
//wypisanie klientów banku (z listą rachunków(w zależności od żądania z saldem lub bez))
//wypisanie rachunków podanego klienta (z saldem lub bez)
//wypisanie wszystkich rachunków w banku(z saldami lub bez)


}
