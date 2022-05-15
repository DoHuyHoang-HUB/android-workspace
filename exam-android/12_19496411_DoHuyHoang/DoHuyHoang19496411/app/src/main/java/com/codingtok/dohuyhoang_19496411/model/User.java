package com.codingtok.dohuyhoang_19496411.model;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private List<Todo> todoList;

    public User() {
    }

    public User(String name, String email, String password, List<Todo> todoList) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.todoList = todoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
