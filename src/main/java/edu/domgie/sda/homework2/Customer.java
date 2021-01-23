package edu.domgie.sda.homework2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private NumberFormat formatter = new DecimalFormat("#000");
    private static int counterOfIdNumber = 1;
    private String firstName;
    private String lastName;
    private int idNumber;
    private List<Acount> listOfAccounts;

    public Customer(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = counterOfIdNumber++;
        this.listOfAccounts = new ArrayList<Acount>();
    }

    //założenie rachunku dla klienta
    public void addAccountToList(Acount account) {
        listOfAccounts.add(account);
    }

    //usunięcie rachunku dla klienta (jeśli stan środków = 0)
    public void removeAccountFromCustomerListIFSaldo0(Acount account) {
        if (account.getBalance() == 0) {
            listOfAccounts.remove(account);
        }
    }

    public List<Acount> getListOfAccounts() {
        return listOfAccounts;
    }

    public String getAccount(boolean withBalance) {
        for (Acount acount : listOfAccounts) {
            return acount.getAccountInformation(withBalance);

        }
        // wyswietla tylko jedne konto danego użytkowanika, pomija kolejne
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    //wypisanie rachunków podanego klienta (z saldem lub bez)
    public void showAccountsOfCustomerWithBalance(boolean withBalance) {
        listOfAccounts.stream()
                .forEach(account -> System.out.println(account.getAccountInformation(withBalance)));
    }

    @Override
    public String toString() {
        return firstName +
                ", " + lastName +
                ", ID: " + formatter.format(idNumber) +
                ", " + listOfAccounts;
    }
}
