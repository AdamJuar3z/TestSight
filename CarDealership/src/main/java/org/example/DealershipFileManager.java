package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class DealershipFileManager {
    private static final String VEHICLE_PATH = "src/main/resources/Vehicle_Inventory.csv";


    public static Dealership getDealership() {

        List<Vehicle> vehicleList = new ArrayList<>();
        Dealership dealership = new Dealership();

        try {
            try (FileInputStream fileInputStream = new FileInputStream(VEHICLE_PATH);
                 Scanner scanner = new Scanner(fileInputStream)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] vehicle = line.split("\\|");
                    if (vehicle.length == 8) {
                        int vin = Integer.parseInt(vehicle[0]);
                        int year = Integer.parseInt(vehicle[1]);
                        String make = vehicle[2];
                        String model = vehicle[3];
                        String vehicleType = vehicle[4];
                        String color = vehicle[5];
                        int odometer = Integer.parseInt(vehicle[6]);
                        double price = Double.parseDouble(vehicle[7]);

                        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                        vehicleList.add(newVehicle);

                        dealership.addVehicles(newVehicle);
                    } else {
                        System.out.println("Invalid data in the file: " + VEHICLE_PATH);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("File not found: " + VEHICLE_PATH);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid data format in the file: " + VEHICLE_PATH);
        }

        return dealership;
    }

    public static void saveDealership(Dealership dealership) {

        try {
            FileWriter writer = new FileWriter("src/main/resources/Vehicle_Inventory.csv", false);
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String csvLine = vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice();
                writer.write(csvLine + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing to the file.");
        }
    }
}
