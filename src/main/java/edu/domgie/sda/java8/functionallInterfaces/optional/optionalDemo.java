package edu.domgie.sda.java8.functionallInterfaces.optional;

import edu.domgie.sda.java8.Car;

import java.util.Optional;

public class optionalDemo {
    public static void main(String[] args) {
        Car familyCar = new Car("Ford SMax", "1.6");
        Car sportCar = new Car("Ford Mustang", "5.4");
        Car volvoCar = new Car("Volvo", "1.7");
        Car unknownCar = null;

        /**
         * Optional to kontener (opakowanie) na obiekty
         * MOże zawierac ten obiek ale moze tez byc pusty
         *
         */

        //pusty kontener na obiekt
        Optional<Car> carOptional = Optional.empty();

        //kontener z zawartościa
        //metoda .of tworzy Optional i wymaga żeby zawartość była
        Optional<Car> carOptionalFilled = Optional.of(familyCar);

        //metoda .ofNullable tworzy Optional i dopuszcza pusta zawartosc
        Optional<Car> carOptionalNullable = Optional.ofNullable(sportCar);

        //Optional na nullu
        Optional<Car> optionalOnUnknown = Optional.ofNullable(unknownCar);


        //pre oprional
        if (volvoCar ==null){
            //do sth
        }


        //z optionalem
        //isPresent testuje czy w Optionalu jest obiekt
        if (carOptionalFilled.isPresent()){
            //.get() wyciaga wlasciwy obiekt z optionala
            Car weKnowYouAreInThere = carOptionalFilled.get();
            System.out.println(weKnowYouAreInThere);
//            System.out.println(carOptionalFilled.get());
        }
        if (optionalOnUnknown.isEmpty()){
            System.out.println("Tu nic nie ma w pudełku");
        }
    }
}
