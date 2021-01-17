package edu.domgie.sda.interfaces.multiExtending;

public class Human implements Student, Performer {

    @Override
    public void perform() {
        System.out.println("Perform method implements");
    }

    @Override
    public void study() {
        System.out.println("Student method implements");
    }

    /**
     * implementacja work() jest zarowno dla interfejsu Worker i Trainer
     * bo w obu mamy ta sama abstrakcyjna metode work()
     */
    @Override
    public void work() {
        System.out.println("Worker method implements");
    }

    @Override
    public void obtainPlan() {
        System.out.println("Obtain plan method implements");
    }
}
