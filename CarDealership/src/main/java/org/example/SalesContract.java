package org.example;

import java.util.Scanner;

public class SalesContract extends Contract {

    private boolean financeOption;
    // The monthlyPayment should only be used if its being financed


    public SalesContract(String date, String customerName,  String customerEmail, Vehicle vehicle, boolean financeOption) {
        super(date, customerName,vehicle, customerEmail);
        this.financeOption = financeOption;


    }

    public double recordingFee() {
        return 100;
    }



    public boolean getFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = true;
    }
    public double salesTax(){
        return getVehicleSold().getPrice() * 0.05 ;
    }

    public double processingFee() {
        double price = getVehicleSold().getPrice();
        double processingFee = 0;
        if (price < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }

        return processingFee;
    }


    @Override
    public double getTotalPrice() {
        boolean isFinanced = this.getFinanceOption();
        if (isFinanced) {
            double P = getVehicleSold().getPrice();
            double r = 0.0425 / 12;
            double R = 0.0525 / 12;
            if (P >= 10000) {
                return (48 * (P * r * Math.pow(1 + r, 48)) / (Math.pow(1 + r, 48) - 1)) + recordingFee() + processingFee() + salesTax();

            } else {
                return (24 * (P * R * Math.pow(1 + R, 24)) / (Math.pow(1 + R, 24) - 1)) + recordingFee() + processingFee() + salesTax();
            }
        } else {
            return getVehicleSold().getPrice() + recordingFee() + processingFee() + salesTax();
        }
    }

    @Override
    public double getMonthlyPayment() {
        boolean isFinanced = this.getFinanceOption();
        double basePrice = getVehicleSold().getPrice();
        double monthlyPayment = 0;
        if (isFinanced) {
            if (basePrice >= 1000) {
                monthlyPayment = getTotalPrice() / 48;

            } else {

                monthlyPayment = getTotalPrice() / 24;
            }
        } else {
            return 0;
        }
        return monthlyPayment;
    }
}

