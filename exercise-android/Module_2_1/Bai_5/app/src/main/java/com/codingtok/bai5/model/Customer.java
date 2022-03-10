package com.codingtok.bai5.model;

public class Customer {
    private String name;
    private int numberOfBooks;
    private boolean vip;
    private double total;
    private final static double PRICE = 20000f;

    public Customer(String name, int numberOfBooks, boolean isVip) {
        this.name = name;
        this.numberOfBooks = numberOfBooks;
        this.vip = isVip;
        this.total = getTotal();
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public double getTotal() {
        return (numberOfBooks * PRICE) - (numberOfBooks * PRICE * (!vip ? 0: (10 * 1f/100))) ;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", numberOfBooks=" + numberOfBooks +
                ", isVip=" + vip +
                ", total=" + total +
                '}';
    }
}
