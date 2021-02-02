package edu.domgie.sda.homework2;

import edu.domgie.sda.java8.streams.Gender;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Acount {
    NumberFormat formatter = new DecimalFormat("#0000000000");
    private static long accountNumberCounter = 1;
    private TypeOfAccount type;
    private BigDecimal balance;
    private long accountNumber;

    public Acount(String type) {
        this.type = TypeOfAccount.getByShortcut(type);
        this.balance = new BigDecimal(0);
        this.accountNumber = accountNumberCounter++;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return formatter.format(accountNumber);
    }

    public TypeOfAccount getType() {
        return type;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountInformation(boolean withBalance) {
        if (withBalance) {
            return "Account: type: " + getType() + ", balance: " + getBalance() + ", accountNumber: " + getAccountNumber();
        } else {
            return "Account: type: " + getType() + ", accountNumber: " + getAccountNumber();
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
