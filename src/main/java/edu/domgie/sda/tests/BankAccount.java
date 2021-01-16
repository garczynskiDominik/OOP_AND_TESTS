package edu.domgie.sda.tests;

public class BankAccount {
    private String firstname;
    private String lastName;
    private double balance;


    public static final int CHECKINGS = 1;
    public static final int SAVING = 2;

    public int accountType;

    public BankAccount() {
        System.out.println("beazparametrowy");
    }

    public BankAccount(String firstname, String lastName, double balance, int accountType) {
        this();
        System.out.println("parametrowy");
        this.firstname = firstname;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }
    public double deposit (double amount, boolean branch){
        if (amount>500D&& !branch) {
            throw new IllegalArgumentException();

        }
        balance+=amount;
        return balance;
    }
    public double withdraw(double amount, boolean branch){
        if (amount>500D && !branch){
            throw new IllegalArgumentException();

        }
        balance-= amount;
        return balance;
    }
    public boolean isSaving(){
        return accountType == SAVING;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public double getBalance() {
        return balance;
    }



}

