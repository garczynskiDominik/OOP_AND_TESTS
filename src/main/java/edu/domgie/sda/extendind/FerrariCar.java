package edu.domgie.sda.extendind;

public class FerrariCar extends SportCar{
    private String model;


    public FerrariCar(int accelerationTo100, String modelName) {
        super(accelerationTo100);
        this.model=modelName;
    }

    @Override
    public String getColor() {
        return "Ferrari is always red";
    }


    public String getColor(String addon){
        return "Ferrari os of collor" + addon;
    }
}
