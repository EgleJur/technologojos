package com.baeldung.thymeleaf.expression;

import java.util.Objects;

public class Dino {
    private int id;
    private String name;
    private String color;
    private String weight;

    public Dino(int id, String name, String color, String weight) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public Dino() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dino dino = (Dino) o;
        return id == dino.id &&
                Objects.equals(name, dino.name) &&
                Objects.equals(color, dino.color) &&
                Objects.equals(weight, dino.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, weight);
    }
}
