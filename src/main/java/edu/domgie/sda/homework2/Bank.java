package edu.domgie.sda.homework2;

import java.math.BigDecimal;
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

    public boolean createNewCustomer(String firstName, String lastName) {
        return listOfClients.add(new Customer(firstName, lastName));
    }

    public boolean addAccountToCustomerList(String firstName, String lastName, String type) {

        for (Customer customer : listOfClients) {
            if (firstName.equalsIgnoreCase(customer.getFirstName()) && lastName.equalsIgnoreCase(customer.getLastName())) {
                customer.addAccountToList(new Acount(type));
                return true;
            }
        }
        System.out.println("We dont have any customer: " + firstName + ", " + lastName);
        return false;
    }
    public boolean migrateAccountForCustomer(String firstName, String lastName, String type, BigDecimal amount) {
        Acount acount = new Acount(type);
        return listOfClients.stream()
                .filter(customer -> firstName.equalsIgnoreCase(customer.getFirstName()) && lastName.equalsIgnoreCase(customer.getLastName()))
                .findAny().get().addMigratedAccount(acount, amount);
    }

    public boolean isDeposit(String firstName, String lastName, String acount, BigDecimal sum) {
        for (Customer customer : listOfClients) {
            if (firstName.equalsIgnoreCase(customer.getFirstName()) &&
                    lastName.equalsIgnoreCase(customer.getLastName())) {
                for (Acount account : customer.getListOfAccounts()) {
                    if (account.getType().equals(TypeOfAccount.getByShortcut(acount))) {
                        account.setBalance(account.getBalance().add(sum));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean withDraw(String firstName, String lastName, String acount, BigDecimal sum) {
        for (Customer customer : listOfClients) {
            if (firstName.equalsIgnoreCase(customer.getFirstName()) &&
                    lastName.equalsIgnoreCase(customer.getLastName())) {
                for (Acount account : customer.getListOfAccounts()) {
                    if (account.getType().equals(TypeOfAccount.getByShortcut(acount))) {
                        if (sum.compareTo(account.getBalance()) < 0) {
                            account.setBalance(account.getBalance().subtract(sum));
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }

    public boolean removeAccountWithoutMoneyFromCustomer(String firstName, String lastName) {
        for (Customer customer : listOfClients) {
            if (firstName.equalsIgnoreCase(customer.getFirstName()) &&
                    lastName.equalsIgnoreCase(customer.getLastName())) {
                for (Acount acount : customer.getListOfAccounts()) {
                    if (acount.getBalance().equals(0)) {
                        customer.getListOfAccounts().remove(acount);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean removeCustomerWihoutAccountsFromBank(String firstName, String lastName) {
        for (Customer customer : listOfClients) {
            if (firstName.equalsIgnoreCase(customer.getFirstName()) &&
                    lastName.equalsIgnoreCase(customer.getLastName())) {
                if (customer.getListOfAccounts().size() == 0) {
                    listOfClients.remove(customer);
                    return true;
                }
            }
        }
        return false;
    }

    public void showAccountOneCustomer(String firstName, String lastName, boolean withbalance) {
        listOfClients.stream()
                .filter(customer -> firstName.equalsIgnoreCase(customer.getFirstName()) &&
                        lastName.equalsIgnoreCase(customer.getLastName()))
                .forEach(customer -> customer.showAccountsOfCustomerWithBalance(withbalance));


//        for (Customer customer : listOfClients) {
//            if (firstName.equalsIgnoreCase(customer.getFirstName()) &&
//                    lastName.equalsIgnoreCase(customer.getLastName())) {
//                customer.showAccountsOfCustomerWithBalance(withbalance);
//            }
//        }
    }

    //wypisanie klientów banku (z listą rachunków(w zależności od żądania z saldem lub bez))
    public void showCustomersAccountsWithBalance(boolean withBalance) {
        listOfClients
                .forEach(client -> System.out.println(client.getFirstName() + ", " + client.getLastName() + ", ID: " + formatter.format(client.getIdNumber()) + ", " + client.getAccount(withBalance)));
    }

    //wypisanie wszystkich rachunków w banku(z saldami lub bez)
    public void showAllAccountsFromBankWithBalance(boolean withBalance) {
        listOfClients.forEach(client -> client.getListOfAccounts().stream().forEach(x -> System.out.println(x.getAccountInformation(withBalance))));
    }
}
