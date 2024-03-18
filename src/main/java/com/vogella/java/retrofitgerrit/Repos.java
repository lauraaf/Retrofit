package com.vogella.java.retrofitgerrit;

public class Repos {
    public String id;
    public String name;

    public String getName() {
        return name;
    }
    public String getId() { return id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
}