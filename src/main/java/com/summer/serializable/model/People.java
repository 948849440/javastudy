package com.summer.serializable.model;

import java.io.Serializable;

public class People implements Serializable {

    private static final long serialVersionUID = 5293569886521001219L;

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init() {
        this.name = "123";
        this.age = 1;
    }
}
