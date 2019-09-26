package ru.Sber.edu;

import java.io.Serializable;
import java.util.ArrayList;

public class Mobile implements Serializable {
    private String name;
    private String model;
    private String color;
    private long id;
    private ArrayList<Mobile> mobiles;

    public Mobile(String Name, String Model, String Color, long Id) {
        this.name = Name;
        this.model = Model;
        this.color = Color;
        this.id = Id;
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

    public void CheckedException() throws Exception
    {
        throw new Exception("true");
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
