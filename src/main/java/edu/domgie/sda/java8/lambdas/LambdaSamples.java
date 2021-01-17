package edu.domgie.sda.java8.lambdas;

public class LambdaSamples{
    public static void main(String[] args) {
        /**
         * Lambda (wyrazenie lamda lub funkcja lambda)
         * postac ()->{}
         * gdzie
         * ()moze ale nie musi zawierac parametry
         * -> operator pomiedzy parametrami a kodem do wykonania
         * {} - zawieraja kod do wykonania, czasem kod mozna
         * zapisac bez tych klamr
         *
         *
         */
        String first = "aaa";
        String second = "bbb";
        /**
         * robimy implementacje interfejsu AtringAdding
         * wyrazenie ponizej odnosi sie do metody abstrakcyjnej
         * z interfejsu
         */
        StringAdding adding = (a, b) -> {
            return a + b;
        };
        //okreslone typy parametrow
        StringAdding addingOneSing = (String a, String b) -> {return a.substring(0,1)+" "+ b.substring(0,1);};
        //okreslone typy ale brak nawiasow klamry i returna
        StringAdding addingOneSingNoReturn = (String a, String b) -> a.substring(0,1)+" "+ b.substring(0,1);

        StringAdding addingOneStringWithMoreInformation = (String a, String b)->{
            System.out.println("Ze srodka lambdy wielonijowej");
            return a.substring(0,1) + " " + b.substring(0,1);
        };

        System.out.println("===========");
        System.out.println(addingOneSing.add(first,second));
        System.out.println("===========");
        System.out.println(adding.add(first,second));
        System.out.println("===========");
        System.out.println(addingOneStringWithMoreInformation.add(first,second));
        System.out.println("===========");

        /**
         * ponizej i powyzej jest tym samym,
         * dzialaja tak samo, roznia sie sposobem zapisu
         */

        StringAdding anotherAdding = new StringAdding() {
            @Override
            public String add(String arg1, String arg2) {
                return arg1 + arg2;
            }
        };
        //Thread Pre Java 8

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Doing some multithreading stuff");
            }
        });
        thread.start();


        // Thread Since Java8
Thread lambda = new Thread(()->{
            System.out.println("Lambda style genereted ");
        });
lambda.start();


IntMultiplication intMultiplication = (int a, int b) -> a*b;
        System.out.println(intMultiplication.multiplicate(5,6));

    }


}
