package com.pluralsight;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }


    public double getTotalPrice() {
        double price = getVehicleSold().getPrice();
        double leaseFee = price * 0.07;
        return leaseFee;
    }


    public double getMonthlyPayment() {
        double price = getVehicleSold().getPrice();
        double expectedEndingValue = price * 0.50;
        double leaseFee = price * 0.07;
        double amountFinanced = price - expectedEndingValue + leaseFee;

        double interestRate = 0.04;
        int months = 36;
        double monthlyRate = interestRate / 12;

        return (amountFinanced * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
