package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {
    private static final String FILE_NAME = "inventory.csv";

    public Dealership getDealership() {
        Dealership dealership = null;
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            if (scanner.hasNextLine()) {
                String[] header = scanner.nextLine().split("\\|");
                dealership = new Dealership(header[0], header[1], header[2]);
            }
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\\|");
                Vehicle v = new Vehicle(
                        parts[0], Integer.parseInt(parts[1]), parts[2], parts[3],
                        parts[4], parts[5], Integer.parseInt(parts[6]), Double.parseDouble(parts[7])
                );
                dealership.addVehicle(v);
            }
        } catch (FileNotFoundException e) {
            System.out.println("inventory.csv not found. Creating new dealership.");
            dealership = new Dealership("Default Dealership", "123 Main St", "000-000-0000");
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            writer.printf("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            for (Vehicle v : dealership.getAllVehicles()) {
                writer.printf("%s|%d|%s|%s|%s|%s|%d|%.2f\n",
                        v.getVin(), v.getYear(), v.getMake(), v.getModel(),
                        v.getType(), v.getColor(), v.getOdometer(), v.getPrice());
            }
        } catch (IOException e) {
            System.out.println("Error saving dealership: " + e.getMessage());
        }
    }
}
