package edu.domgie.sda.homework2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private NumberFormat formatter = new DecimalFormat("#000");
    private static int counterOfIdNumber=1;
    private String firstName;
    private String lastName;
    private int idNumber ;
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

    public List getListOfAccounts() {
        return listOfAccounts;
    }

    //wypisanie rachunków podanego klienta (z saldem lub bez)
    public void showAccountsOfCustomerWithSaldo() {
        listOfAccounts.forEach(System.out::println);
    }

    public void showAccountsOfCustomerWithoutSaldo() {
        listOfAccounts.stream().forEach(account->{
            System.out.println(("Account: type: "
                    + account.getType()
                    + ", accountNumber"
                    + account.getAccountNumber()));
        });
    }

    @Override
    public String toString() {
        return "Customer: " +
                " " + firstName +
                ", " + lastName +
                ", ID: " +formatter.format(idNumber)  +
                ", " + listOfAccounts;
    }
}
