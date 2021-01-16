package edu.domgie.sda.oopBasics.composition;

public class Adress {

    private String street;
    private String city;
    private String country;

    public Adress(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
