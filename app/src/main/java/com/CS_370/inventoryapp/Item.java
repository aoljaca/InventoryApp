package com.CS_370.inventoryapp;

public class Item {
    private long id;
    private String name;
    private String description;
    private String username;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username;};
    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;};

    public String getDescription() {return description;};

    public void setDescription(String description) {this.description = description;}
    public Item(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
