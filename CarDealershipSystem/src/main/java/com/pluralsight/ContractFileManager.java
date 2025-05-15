package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractFileManager {
    private static final String FILE_NAME = "contracts.csv";

    public void saveContract(Contract contract) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            StringBuilder sb = new StringBuilder();

            String type = (contract instanceof SalesContract) ? "SALE" : "LEASE";
            sb.append(type).append("|")
                    .append(contract.getDate()).append("|")
                    .append(contract.getCustomerName()).append("|")
                    .append(contract.getCustomerEmail()).append("|");


            Vehicle v = contract.getVehicleSold();
            sb.append(v.getVin()).append("|")
                    .append(v.getYear()).append("|")
                    .append(v.getMake()).append("|")
                    .append(v.getModel()).append("|")
                    .append(v.getPrice()).append("|");


            if (contract instanceof SalesContract s) {
                double salesPrice = v.getPrice();
                double tax = salesPrice * 0.05;
                double recordingFee = 100;
                double processingFee = (salesPrice < 10000) ? 295 : 495;

                sb.append(String.format("%.2f|", tax))
                        .append(String.format("%.2f|", recordingFee))
                        .append(String.format("%.2f|", processingFee))
                        .append(String.format("%.2f|", s.getTotalPrice()))
                        .append(s.getMonthlyPayment() > 0 ? "YES|" : "NO|")
                        .append(String.format("%.2f", s.getMonthlyPayment()));
            }
            else if (contract instanceof LeaseContract l) {
                double price = v.getPrice();
                double expectedEndingValue = price * 0.50;
                double leaseFee = price * 0.07;

                sb.append(String.format("%.2f|", expectedEndingValue))
                        .append(String.format("%.2f|", leaseFee))
                        .append(String.format("%.2f|", l.getTotalPrice()))
                        .append(String.format("%.2f", l.getMonthlyPayment()));
            }

            writer.println(sb.toString());
            System.out.println("Contract saved!");
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
