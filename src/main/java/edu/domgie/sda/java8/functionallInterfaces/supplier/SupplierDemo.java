package edu.domgie.sda.java8.functionallInterfaces.supplier;

import edu.domgie.sda.java8.Car;

import java.util.function.Supplier;

public interface SupplierDemo {
    public static void main(String[] args) {
        Car famillyCar = new Car("Ford SMax","3.0");
        // lambda z return
        Supplier<Car> sportCar  = ()-> { return new Car("Ford Mustang GT", "5.4");};
        //lambda bez return i klamerek
        Supplier<Car> vanCar = ()-> new Car("VW Transporter","2.5");
        /**
         * supplier dostarcza obiekt jak trzeba,
         * czyli w przypadku wywolania a nie w momendzie wpisania kodu
         */
        System.out.println(sportCar.get());
        System.out.println("\nInfo o samochodzie spotowym");
        System.out.println(carInfo(sportCar));
        System.out.println("\nInfo o samochodzie dostawczym");
        System.out.println(carInfo(vanCar));
    }

    //wykonianie metody z przekazanym intrefejsem
    public static String carInfo(Supplier<Car> carTochck){
        Car passedCar = carTochck.get();
        return new StringBuilder(passedCar.getName())
                .append("")
                .append(passedCar.getEngine())
                .toString();
    }
}
