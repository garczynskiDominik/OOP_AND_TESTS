package edu.domgie.sda.homework2;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private int idNumber;
    private List<AcountClass> listOfAccounts;

    public Customer(String firstName, String lastName, int idNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.listOfAccounts = new ArrayList<AcountClass>();
    }

    //założenie rachunku dla klienta
    public void addAccountToList(AcountClass account) {
        listOfAccounts.add(account);
    }

    //usunięcie rachunku dla klienta (jeśli stan środków = 0)
    public void removeAccountFromCustomerListIFSaldo0(AcountClass account) {
        if (account.getSaldo() == 0) {
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

//        for (AcountClass account : listOfAccounts) {
//            System.out.println("Account: type: "
//                    + account.getType()
//                    + ", accountNumber"
//                    + account.getAccountNumber());
//        }
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
