package edu.domgie.sda.homework2;

public class Acount {
    private TypeOfAccount type;
    private double saldo;
    private long accountNumber;

    public Acount(TypeOfAccount type, double saldo, long accountNumber) {
        this.type = type;
        this.saldo = saldo;
        this.accountNumber = accountNumber;
    }

    public double getSaldo() {
        return saldo;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public TypeOfAccount getType() {
        return type;
    }

    //wpłata na rachunek
    public void transferToAccount(double saldo) {
        this.saldo = this.saldo + saldo;
    }

    //wypłata z rachunku (do wysokości salda)
    public void withDraw(double saldo) {
        if (saldo < this.saldo - saldo) {
            this.saldo = this.saldo - saldo;
        }
    }

    @Override
    public String toString() {
        return "Acount: " +
                "type: " + type +
                ", saldo: " + saldo +
                ", accountNumber: " + accountNumber;
    }
}
