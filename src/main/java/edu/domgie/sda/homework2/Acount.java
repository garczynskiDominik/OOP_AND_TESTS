package edu.domgie.sda.homework2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Acount {
    NumberFormat formatter = new DecimalFormat("#0000000000");
    private static long accountNumberCounter = 1;
    private TypeOfAccount type;
    private double balance;
    private long accountNumber;

    public Acount(TypeOfAccount type) {
        this.type = type;
        this.balance = 0;
        this.accountNumber = accountNumberCounter++;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return formatter.format(accountNumber);
    }

    public TypeOfAccount getType() {
        return type;
    }

    //wpłata na rachunek
    public boolean isdepositComplete(double saldo) {
        this.balance = this.balance + saldo;
        if (this.balance != this.balance + saldo) {
            return false;
        }
        return true;
    }

    //wypłata z rachunku (do wysokości salda)
    public boolean withDraw(double saldo) {
        if (saldo < this.balance - saldo) {
            this.balance = this.balance - saldo;
            return true;
        } else return false;
    }
    public String getAccountInformation(boolean withBalance){
        if (withBalance){
            return "Account: type: "+getType()+", balance: "+getBalance()+", accountNumber: " +getAccountNumber();
        }else {
            return "Account: type: "+getType()+", accountNumber: " +getAccountNumber();
        }
    }

    @Override
    public String toString() {
        return "Acount: " +
                "type: " + type +
                ", balance: " + balance +
                ", accountNumber: " + formatter.format(accountNumber);
    }
}
