package edu.domgie.sda.java8.lambdas;

/**
 * Andnotacja @FunctionalInterface oznacza interfejs funkcyjny
 * czyli taki ktory ma dokladnie jedna metode abstrakcyjna
 *
 * Dopuszczalne sa inne metody w interfejsie ale wtedy musza miec
 * domyslna implementacje (default)
 */
@FunctionalInterface
public interface StringAdding {
    //jedna metoda abstr w interfejsie funkcyjnym
    String add(String arg1, String arg2);

    /**
     * jesli dopiszemy kolejna metode abstr to Ide podswietli adnotacje
     */
    default void  testAnotherMethod(){
        System.out.println("This is default method from interface");
    };
}
