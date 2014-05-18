package dataMapperDB;

import dataMapperDB.annotations.Entity;

/**
 * Created by tish on 11.05.2014.
 */
@Entity(name = "Car")
public class Car {
    private String mark;
    private String model;
    private int price;
    private long id;

    public Car(String mark, String model, int coast) {
        this.mark = mark;
        this.model = model;
        this.price = coast;
    }

    public Car(){

    }

    public String getMark() {

        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }
}
