package com.example.demo.thymeleaf.user;

public class user {
    protected int age;
    protected String name;

    public user() {
    }

    public user(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
