package com.pluralsight;

public class SalesContract extends Contract {
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }


    public double getTotalPrice() {
        double salesPrice = getVehicleSold().getPrice();
        double tax = salesPrice * 0.05;
        double recordingFee = 100;
        double processingFee = (salesPrice < 10000) ? 295 : 495;

        return salesPrice + tax + recordingFee + processingFee;
    }


    public double getMonthlyPayment() {
        if (!isFinanced) return 0;

        double amount = getTotalPrice();
        double interestRate;
        int months;

        if (getVehicleSold().getPrice() >= 10000) {
            interestRate = 0.0425;
            months = 48;
        } else {
            interestRate = 0.0525;
            months = 24;
        }

        double monthlyRate = interestRate / 12;
        return (amount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}
