package edu.domgie.sda.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    BankAccount dominik;

    @BeforeEach
    public void setupe() {
        dominik = new BankAccount("Dominik", "Garczynski", 100, 1);
    }


    @Test
    public void testDepositInBranch() {
        double expectdBalance = 700;
        double toCheck = 600;

        double resultBalance = dominik.deposit(toCheck, true);
        assertEquals(expectdBalance, resultBalance, "Zly wynik" + resultBalance + "siema");
    }

    @Test
    public void testDepositnotInBranch() {
        double expect = 700;
        try {
            double balance = dominik.deposit(600, false);
            fail("IllegarArgumentException but not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(IllegalArgumentException.class,e.getClass());
        }
    }


    @Test
    public void testDepositInBranchWithAssertTrows(){
        assertThrows(IllegalArgumentException.class, () -> dominik.deposit(600, false));
    }

    @Test
    public void testWithDraw() {
        double toCheck = 100;
        double expected = 0;

        double resoult = dominik.withdraw(toCheck, false);
        assertEquals(expected, resoult, "zly wynik");
    }

    @Test
    public void testIsSaving() {
        boolean toChcek = false;
        boolean expect = true;
        boolean resoult = dominik.isSaving();

        assertEquals(expect, toChcek);
    }

}