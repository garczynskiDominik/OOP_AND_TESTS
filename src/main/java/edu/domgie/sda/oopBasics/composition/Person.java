package edu.domgie.sda.oopBasics.composition;

public class Person {
    private String firstName;
    private String lastName;

    private Adress homeAdress;
    private Adress workAdress;
    private Adress schollAdress;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addHomeAdress(String street, String city, String country) {
        this.homeAdress= new Adress(street,city,country);
    }
    public Adress getHomeAdress(){
        return homeAdress;
    }

}
