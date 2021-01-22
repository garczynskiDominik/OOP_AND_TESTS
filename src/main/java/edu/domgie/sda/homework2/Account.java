package edu.domgie.sda.homework2;

public class Account {
    private TypeOfAccount typeOfAccount;
    private double saldo;
    private long accountNumber;

    public Account(TypeOfAccount typeOfAccount, double saldo, long accountNumber) {
        this.typeOfAccount = typeOfAccount;
        this.saldo = saldo;
        this.accountNumber = accountNumber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferToKonto(double saldo) {
        this.saldo = this.saldo + saldo;
    }

    public void withDraw(double saldo) {
        if (this.saldo-saldo>this.saldo)
        this.saldo = this.saldo-saldo;
    }

    @Override
    public String toString() {
        return "Account:" +
                "type: " + typeOfAccount +
                ", saldo: " + saldo +
                ", accountNumber:" + accountNumber;
    }
}
