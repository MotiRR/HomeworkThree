package ru.sber.edu;

import java.io.Serializable;
import java.util.ArrayList;

public class Mobile implements Serializable {
    private String name;
    private String model;
    private String color;
    private long id;
    private ArrayList<Mobile> mobiles;

    public Mobile(String name, String model, String color, long id) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.id = id;
        mobiles = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void addMobile(Mobile mobile)
    {
        mobiles.add(mobile);
    }

    public Mobile getMobile(int index)
    {
        return mobiles.get(index);
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", color='" + model + '\'' +
                ", color='" + color + '\'' +
                ", id=" + id +
                '}';
    }
}
