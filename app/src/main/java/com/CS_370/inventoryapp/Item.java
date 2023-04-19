package com.CS_370.inventoryapp;

public class Item {
    private long id;
    private String name;
    private String description;
    private String username;
    /** Get ID Function
     @param void
     @returns - long
     **/
    public long getId() {
        return id;
    }
    /** Get Username Function
     @param void
     @returns - String
     **/
    public String getUsername() {
        return username;
    }
    // Set username
    public void setUsername(String username) {this.username = username;};
    public String getName() {
        return name;
    }
    // Set name
    public void setName(String name) {this.name = name;};
    // Get Description
    public String getDescription() {return description;};
    // Set Description
    public void setDescription(String description) {this.description = description;}
    public Item(long id, String name, String description, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.username = username;
    }
}
