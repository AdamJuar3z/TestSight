package org.example;

public abstract class Contract {
    private String date;
    private String customerName;
    private Vehicle vehicleSold;
    private String customerEmail;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, Vehicle vehicleSold, String customerEmail) {
        this.date = date;
        this.customerName = customerName;
        this.vehicleSold = vehicleSold;
        this.customerEmail = customerEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getTotalPrice() {
        return 0;


    }

    public double getMonthlyPayment() {
        return 0; /// incorrect value

    }
}