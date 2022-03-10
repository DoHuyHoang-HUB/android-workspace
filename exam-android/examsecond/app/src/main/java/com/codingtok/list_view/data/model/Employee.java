package com.codingtok.list_view.data.model;

public class Employee {
    private String id;
    private String name;
    private boolean gender;
    private String department;
    private String image;

    public Employee(String id, String name, boolean gender, String department, String image) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.image = image;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", department='" + department + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
