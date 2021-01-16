package edu.domgie.sda.collections;

import java.util.Collections;
import java.util.Objects;

public class CollectionsCar  implements Comparable<CollectionsCar>{
    private String name;
    private String engine;
    private Integer maxSpeed;
    private String color;


    public CollectionsCar(String name, String engine, int maxSpeed) {
        this.name = name;
        this.engine = engine;
        this.maxSpeed = maxSpeed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color != null ? getColorAsExists() : "";
    }

    private String getColorAsExists() {
        return color;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "CollectionsCar   {" +
                "name='" + name + '\'' +
                ", engine='" + engine + '\'' +
                ", maxSpeed='" + maxSpeed + '\'' +
                (color != null ? "color=" + color + '\'' : getColorAsExists()+"") +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, engine, maxSpeed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }
        CollectionsCar car = (CollectionsCar) o;
        return maxSpeed == car.maxSpeed &&
                name.equals(car.name)&&
                engine.equalsIgnoreCase(car.engine);
    }


    @Override
    public int compareTo(CollectionsCar anotherCar) {
        return engine.compareTo(anotherCar.engine);
//        return anotherCar.getEngine().compareTo(this.engine);
    }
}
