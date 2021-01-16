package edu.domgie.sda.extendind;

public class SportCar extends Car{
    private int accelerationTo100;

    public SportCar(int accelerationTo100) {
        this.accelerationTo100 = accelerationTo100;
    }

    public int getAccelerationTo100() {
        return accelerationTo100;
    }
}
