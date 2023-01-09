package com.example.tpd_client.models;

public class Motorcycle {
    private int id;
    private String brand;

    public Motorcycle(int id, String brand, int yearOfProduction) {
        this.id = id;
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
    }

    public Motorcycle(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    private int yearOfProduction;
}
