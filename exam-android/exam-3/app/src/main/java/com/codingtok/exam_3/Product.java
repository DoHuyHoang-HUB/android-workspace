package com.codingtok.exam_3;

import androidx.annotation.DrawableRes;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private double price;
    @DrawableRes
    private int image;
    private float rating;
    private int reviews;
    private int sold;
    private String traderMark;
    private String origin;
    private String description;

    public Product(String name, double price, int image, float rating, int reviews, int sold, String traderMark, String origin, String description) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.rating = rating;
        this.reviews = reviews;
        this.sold = sold;
        this.traderMark = traderMark;
        this.origin = origin;
        this.description = description;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getTraderMark() {
        return traderMark;
    }

    public void setTraderMark(String traderMark) {
        this.traderMark = traderMark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", image=" + image +
                ", rating=" + rating +
                ", reviews=" + reviews +
                ", sold=" + sold +
                ", traderMark='" + traderMark + '\'' +
                ", origin='" + origin + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
