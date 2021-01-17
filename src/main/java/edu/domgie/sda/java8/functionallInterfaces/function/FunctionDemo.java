package edu.domgie.sda.java8.functionallInterfaces.function;

import edu.domgie.sda.java8.Car;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Ford Mustang", "5.4");
        Car volvoCar = new Car("Volvo", "1.7");


        /**
         * Function przyjmuje obiekt i zwraca inny obiekt
         */
        Function<Car,String> getEngine = x-> x.getEngine();
        Function<Car,String> nameUpperCase = x->x.getName().toUpperCase();
        System.out.println("====================================");
        System.out.println(getEngine.apply(sportCar));
        System.out.println("====================================");
        System.out.println(nameUpperCase.apply(familyCar));

        Function<Car,Car> upgradeCar = car->
        {return new Car("upgraded " + car.getName(),car.getEngine()+ " Turbo");};
        Car newCar = upgradeCar.apply(volvoCar);


        System.out.println(newCar);


    }
}
