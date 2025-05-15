package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(String vin) {
        inventory.removeIf(v -> v.getVin().equalsIgnoreCase(vin));
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }


    public List<Vehicle> searchByPrice(double min, double max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getPrice() >= min && v.getPrice() <= max)
                results.add(v);
        }
        return results;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model))
                results.add(v);
        }
        return results;
    }

    public List<Vehicle> searchByYear(int min, int max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getYear() >= min && v.getYear() <= max)
                results.add(v);
        }
        return results;
    }

    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getColor().equalsIgnoreCase(color))
                results.add(v);
        }
        return results;
    }

    public List<Vehicle> searchByMileage(int min, int max) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getOdometer() >= min && v.getOdometer() <= max)
                results.add(v);
        }
        return results;
    }

    public List<Vehicle> searchByType(String type) {
        List<Vehicle> results = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getType().equalsIgnoreCase(type))
                results.add(v);
        }
        return results;
    }


    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}
