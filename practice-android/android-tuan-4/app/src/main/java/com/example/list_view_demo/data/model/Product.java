package com.example.list_view_demo.data.model;

public class Product {
    private String name;
    private String shopName;
    private int image;

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

    @Override
    public String toString() {
        return "Product{" +
                ", name='" + name + '\'' +
                ", shopName='" + shopName + '\'' +
                ", image=" + image +
                '}';
    }
}
