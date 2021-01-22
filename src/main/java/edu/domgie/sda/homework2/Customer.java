package edu.domgie.sda.homework2;

import java.util.ArrayList;
import java.util.List;

public class Customer{
    private String firstName;
    private String lastName;
    private int idNumber;
    private List listOfAccounts;

    public Customer(String firstName, String lastName, int idNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.listOfAccounts = new ArrayList<Account>();
    }

    public void addAccountToList(Account account) {
        listOfAccounts.add(account);
    }


    public void removeAccountFromCustomerList(Account account) {
        if (account.getSaldo <= 0) {
            listOfAccounts.remove(account);
        }
    }

    public List getListOfAccounts() {
        return listOfAccounts;
    }


    @Override
    public String toString() {
        return "Customer: " +
                " " + firstName +
                ", " + lastName +
                ", ID: " + idNumber +
                ", " + listOfAccounts;
    }
}
