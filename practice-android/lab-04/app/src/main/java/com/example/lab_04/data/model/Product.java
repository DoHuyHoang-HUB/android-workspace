package com.example.lab_04.data.model;

public class Product {
    private String name;
    private String shopName;
    private int image;
    private float rating;
    private double price;
    private float discount;

    public Product(String name, int image, float rating, double price, float discount) {
        this.name = name;
        this.image = image;
        this.rating = rating;
        this.price = price;
        this.discount = discount;
    }

    public Product(String name, String shopName, int image) {
        this.name = name;
        this.shopName = shopName;
        this.image = image;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", shopName='" + shopName + '\'' +
                ", image=" + image +
                ", rating=" + rating +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
