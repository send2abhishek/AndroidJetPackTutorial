package com.attra.androidjetpacktutorial.Models;

public class DataModels {

    private String name;
    private String email;

    public DataModels(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
