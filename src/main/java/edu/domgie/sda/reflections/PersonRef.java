package edu.domgie.sda.reflections;

public class PersonRef {
    public int age;
    private String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    protected String getDetailGenderInfo() {
        return gender.equals("Kobieta") ? "Kobiety gora" : "Mezczyzni gora";
    }

    String getAgeSummary() {
        return age >= 18 ? "Dorosly" : "Co ty wiesz ozyciu";
    }

    private String ageHelper() {
        return age > 75 ? "Moze pomoc" : "Dasz rade";
    }
}
