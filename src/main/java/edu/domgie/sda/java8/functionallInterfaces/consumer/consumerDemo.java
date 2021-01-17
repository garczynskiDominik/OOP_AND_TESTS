package edu.domgie.sda.java8.functionallInterfaces.consumer;

import edu.domgie.sda.java8.Car;

import java.util.function.Consumer;

public class consumerDemo {
    public static void main(String[] args) {
        Car sportCar = new Car("Porsche 911", "4.5");
        Car familyCar = new Car("Volvo V50", "2.0");


        /**
         * Consumer jako parametr przyjmuje obiekt
         * wykonuje jakies dzialanie
         * i nic nie zwraca
         */
        Consumer<Car> printCarMark = (car) -> {
            System.out.println(car.getName());
            car.getName().substring(0, car.getName().indexOf(" "));
        };
        Consumer<Car> printCarInfoNoSpaces = (car)->{
            System.out.println(car.getName().replaceAll(" ", "")
                    +car.getEngine().replaceAll(" ",""));
        };

        printCarMark.accept(familyCar);
        printCarMark.accept(sportCar);
        System.out.println("Sout jest consumerem, nie w prost ale w uwagi" +
                "na sposob dzialania napewno");

        printCarInfoNoSpaces.accept(sportCar);
    }
}
