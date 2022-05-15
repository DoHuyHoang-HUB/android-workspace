package com.codingtok.a19496411_dohuyhoang_baiktthuchanh.model;

public class Todo {
    private String todo;
    private String status;

    public Todo() {
    }

    public Todo(String todo, String status) {
        this.todo = todo;
        this.status = status;
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

    @Override
    public String toString() {
        return "Todo{" +
                "todo='" + todo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
