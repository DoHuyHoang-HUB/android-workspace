package com.codingtok.android_tuan5.data;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class Food implements Serializable {
    private int id;
    private String nameFood;
    @DrawableRes
    private int imageFood;
    private String description;
    private double price;

    public Food(int id, String nameFood, int imageFood, String description, double price) {
        this.id = id;
        this.nameFood = nameFood;
        this.imageFood = imageFood;
        this.description = description;
        this.price = price;
    }

    public Food() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getImageFood() {
        return imageFood;
    }

    public void setImageFood(int imageFood) {
        this.imageFood = imageFood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", nameFood='" + nameFood + '\'' +
                ", imageFood=" + imageFood +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
