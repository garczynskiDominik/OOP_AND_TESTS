package edu.domgie.sda.java8.lambdas;

/**
 * jak klasa implementujaca interfejs ma w nazwie Impl
 * albo cos podobnego to znaczy ze nie ma dla niej dobrej nazwy
 * albo moze interfejs jest niepotrzebny
 */
public class StringAddingImp implements StringAdding {

    @Override
    public String add(String arg1, String arg2) {
        return null;
    }

    @Override
    public void testAnotherMethod() {

        System.out.println("Metoda przykryta z klasy");

    }
}
