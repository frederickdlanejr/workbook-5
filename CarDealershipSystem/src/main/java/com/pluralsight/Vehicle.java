package com.pluralsight;

public class Vehicle {
    private String vin;
    private int year;
    private String make;
    private String model;
    private double price;

    public Vehicle(String vin, int year, String make, String model, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public String getVin() { return vin; }
    public int getYear() { return year; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
}
