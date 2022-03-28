package com.example.android_tuan_7.data.model;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class Shoes implements Serializable {
    private String name;
    private float discount;
    @DrawableRes
    private int image;

    public Shoes(String name, float discount, int image) {
        this.name = name;
        this.discount = discount;
        this.image = image;
    }

    public Shoes() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "name='" + name + '\'' +
                ", discount=" + discount +
                ", image=" + image +
                '}';
    }
}
