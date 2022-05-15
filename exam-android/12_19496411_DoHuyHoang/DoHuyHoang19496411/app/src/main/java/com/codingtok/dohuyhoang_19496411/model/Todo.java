package com.codingtok.dohuyhoang_19496411.model;

public class Todo {
    private String todo;
    private String status;
    private User user;

    public Todo() {
    }

    public Todo(String todo, String status, User user) {
        this.todo = todo;
        this.status = status;
        this.user = user;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todo='" + todo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
