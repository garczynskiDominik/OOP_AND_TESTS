package edu.domgie.sda.java8.streams;

public class Human implements Comparable<Human>{
    private String name;
    private String surname;
    private int age;
    private Gender gender;

    public Human(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Human(String name, String surname, int age, String genderShortCutPL) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender=Gender.getByShortcutPl(genderShortCutPL);
    }
    public boolean isOver20AndMan(){
        return age> 20 && "M".equals(getGender().getShortcutPl());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return "Human: " +
                ", " + name + '\'' +
                ", " + surname + '\'' +
                ", age: " + age +
                ", " + gender.getTranslationPl();
    }

    @Override
    public int compareTo(Human human) {

        return surname.compareTo(human.getSurname());
    }
}
