package edu.domgie.sda.java8.functionallInterfaces.predicate;

import edu.domgie.sda.java8.Car;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Ford Mustang", "5.4");
        Car volvoCar = new Car("Volvo", "1.7");
        /**
         * Predykat sluzy do testowania warunku,
         * przyjmuje obiekt, zwraca boolean
         */

        Predicate<Car> isSmallEngine = x -> x.getEngine().compareTo("2.0") < 0;
        Predicate<Car> isFord = a -> a.getName().startsWith("Ford");


        if (isFord.test(volvoCar)){
            System.out.println(familyCar);
        }else{
            System.out.println("Tested car isint Ford");
        }
        printCar(familyCar,isSmallEngine);
        printCar(sportCar,isFord);
        printCar(volvoCar,isFord);


    }
    private static void printCar(Car car, Predicate<Car> condition){
        if (condition.test(car)){
            System.out.println("Passed: " +car.getName() + " "+ car.getEngine());

        }
    }

}
