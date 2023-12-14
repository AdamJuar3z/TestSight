package org.example;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone, List<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getVehicleByPrice(double min, double max) {
       return inventory.stream().filter(vehicle -> vehicle.getPrice() <= max).toList();
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        return inventory.stream().filter(vehicle -> vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel()
                .equalsIgnoreCase(model)).collect(Collectors.toList());
    }
    public List<Vehicle> getVehicleByYear(int min, int max) {
        return inventory.stream().filter(vehicle -> vehicle.getYear() >= min && vehicle.getYear() <= max).toList();
    }

    public List<Vehicle> getVehicleByColor(String color) {
       return inventory.stream().filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color)).toList();
    }

    public List<Vehicle> getVehicleByMileage(double min, double max) {
        return inventory.stream().filter(vehicle -> vehicle.getOdometer() >= min && vehicle.getOdometer() <= max).toList();

    }

    public List<Vehicle> getVehicleByType(String vehicleType) {
      return inventory.stream().filter(vehicle -> vehicle.getVehicleType().equalsIgnoreCase(vehicleType)).toList();
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicles(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }
}