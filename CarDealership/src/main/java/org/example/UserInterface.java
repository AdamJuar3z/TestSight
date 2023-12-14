package org.example;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    String RESET = "\u001B[0m";
     String RED = "\u001B[31m";
     String GREEN = "\u001B[32m";
     String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";

    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";


    static Dealership dealership;
    private static final String FILE_PATH = "src/main/resources/Vehicle_Inventory.csv";

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean isMakingSelection = true;

        while (isMakingSelection) {
            System.out.println(RED+ "Welcome to Puros precios Locos Dealership!\n Choose an option below:\n"+ RESET);
            System.out.println("1 - Find vehicles within a price range.");
            System.out.println("2 - Find vehicles by make/model.");
            System.out.println("3 - Find vehicles by year range.");
            System.out.println("4 - Find vehicles by color.");
            System.out.println("5 - Find vehicles by mileage range.");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van).");
            System.out.println("7 - List ALL vehicles.");
            System.out.println("8 - Add a vehicle.");
            System.out.println("9 - Remove a vehicle.");
            System.out.println("10) Buy a vehicle");
            System.out.println("11) Lease a vehicle");
            System.out.println("0 - Quit.");
            System.out.println("Please enter a number: ");
            int choice = -1;
            boolean isValidInput = false;


            while (!isValidInput) {
                try {
                    choice = scanner.nextInt();
                    isValidInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }


            switch (choice) {
                case 1:
                    processByPrice();
                    break;
                case 2:
                    processFilterByMakeModel();
                    break;
                case 3:
                    processFilterByYear();
                    break;
                case 4:
                    processFilterByColor();
                    break;
                case 5:
                    processFilterByMileage();
                    break;
                case 6:
                    processFilterByVehicleType();
                    break;
                case 7:
                    processListAllVehicles();
                    break;
                case 8:
                    processAddVehicle();
                    DealershipFileManager.saveDealership(dealership);
                    break;
                case 9:
                    processRemoveVehicle();
                    DealershipFileManager.saveDealership(dealership);
                    break;
                case 10:
                    processBuyVehicle();
                    DealershipFileManager.saveDealership(dealership);
                    break;
                case 11:
                    processLeasedVehicle();
                    DealershipFileManager.saveDealership(dealership);
                    break;

                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid choice.");
            }
        }
    }

    private void processByPrice() {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();

        List<Vehicle> filteredVehicles = dealership.getVehicleByPrice(min, max);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByMakeModel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter make: ");
        String make = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();

        List<Vehicle> filteredVehicles = dealership.getVehicleByMakeModel(make, model);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehicleByYear(minYear, maxYear);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = scanner.next();

        List<Vehicle> filteredVehicles = dealership.getVehicleByColor(color);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByMileage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum mileage: ");
        double minMileage = scanner.nextDouble();
        System.out.print("Enter maximum mileage: ");
        double maxMileage = scanner.nextDouble();

        List<Vehicle> filteredVehicles = dealership.getVehicleByMileage(minMileage, maxMileage);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByVehicleType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String vehicleType = scanner.next();

        List<Vehicle> filteredVehicles = dealership.getVehicleByType(vehicleType);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processListAllVehicles() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayFilteredVehicles(allVehicles);

    }

    private void processAddVehicle() {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Please enter the following information.");
            System.out.print("Enter VIN: ");
            int vin = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the vehicle's year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter the vehicle's make: ");
            String make = scanner.nextLine();
            System.out.print("Enter the vehicle's model: ");
            String model = scanner.nextLine();
            System.out.print("Enter the vehicle type (car, truck, SUV, van): ");
            String vehicleType = scanner.nextLine();
            System.out.print("Enter the vehicle's color: ");
            String color = scanner.nextLine();
            System.out.print("Enter the vehicle's odometer: ");
            int odometer = scanner.nextInt();
            System.out.print("Enter the vehicle's price: ");
            double price = scanner.nextDouble();


            Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

            dealership.addVehicles(newVehicle);

            String csvLine = newVehicle.getVin() + "|" + newVehicle.getYear() + "|" +
                    newVehicle.getMake() + "|" + newVehicle.getModel() + "|" +
                    newVehicle.getVehicleType() + "|" + newVehicle.getColor() + "|" +
                    newVehicle.getOdometer() + "|" + newVehicle.getPrice();
            fileWriter.write(csvLine + System.lineSeparator());
            fileWriter.flush();

            System.out.println("New vehicle added successfully.\n");
            System.out.println("Would you like to: ");
            System.out.println("1) Go back?");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    display();
                    break;
                default:
                    System.out.println("Please select a valid choice.");
                    break;
            }

        } catch (IOException e) {
            System.out.println("Error occurred while adding the vehicle: " + e.getMessage());
        }
    }
    private void processRemoveVehicle() {
        System.out.println("Please enter the VIN of the vehicle you want to remove:");
        Scanner scanner = new Scanner(System.in);
        int vinToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer

        List<Vehicle> inventory = dealership.getAllVehicles();
        boolean removed = false;

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vinToRemove) {
                dealership.removeVehicle(vehicle);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Vehicle with VIN " + vinToRemove + " has been removed from the inventory.");

            try (FileWriter fileWriter = new FileWriter(FILE_PATH, false)) {
                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    String csvLine = vehicle.getVin() + "|" + vehicle.getYear() + "|" +
                            vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                            vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                            vehicle.getOdometer() + "|" + vehicle.getPrice();
                    fileWriter.write(csvLine + System.lineSeparator());
                }
                System.out.println("Inventory updated in the file: " + FILE_PATH);
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }
        } else {
            System.out.println("No vehicle found with VIN " + vinToRemove + " in the inventory.");
        }
    }

    private void displayFilteredVehicles(List<Vehicle> filteredVehicles) {
        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("Filtered Vehicles:");
            for (Vehicle vehicle : filteredVehicles) {
                System.out.println(vehicle);
            }
        }
    }
    public void processBuyVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You are purchasing a vehicle");
        boolean isFinanced = false;
        boolean vinFound = false;
        String choice = null;

        System.out.println("Please enter the VIN of the car you would like to buy");
        if (scanner.hasNextInt()) {
            int vinToSearch = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Would you like to finance? (Yes/No)");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                isFinanced = true;
            } else if (choice.equalsIgnoreCase("no")) {
                isFinanced = false;
            } else {
                System.out.println("Invalid answer, please enter yes or no.");
                return;
            }
            System.out.println("Enter the following information below: \n");
            System.out.println("Please enter the date.");
            String date = scanner.nextLine();
            System.out.println("Please enter your name.");
            String customerName = scanner.nextLine();
            System.out.println("Please enter your email.");
            String customerEmail = scanner.nextLine();
            List<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {

                if (vinToSearch == vehicle.getVin()) {

                    vinFound = true;
                    SalesContract salesContract = new SalesContract(date, customerName, customerEmail, vehicle, isFinanced);
                    salesContract.getTotalPrice();
                    salesContract.getMonthlyPayment();
                    System.out.printf("Your Total Price will be: %.2f %n", salesContract.getTotalPrice());
                    System.out.printf("Your monthly payment will be %.2f %n", salesContract.getMonthlyPayment());
                    System.out.println("Would you like to buy it?");
                    if (scanner.hasNextLine()) {

                        String buyChoice = scanner.nextLine();
                        if (buyChoice.equalsIgnoreCase("yes")) {

                            dealership.removeVehicle(vehicle);
                            System.out.println("Removed vehicle with VIN " + vinToSearch);

                            ContractFileManager.writeCustomerInfoToFile("SALE", date, customerName, customerEmail, vehicle, salesContract.salesTax(), salesContract.recordingFee(),
                                    salesContract.processingFee(), salesContract.getTotalPrice(), choice, salesContract.getMonthlyPayment());
                            System.out.println("Car successfully purchased. CONGRATS!!!");
                        } else {
                            System.out.println("Contract Rejected. Returning back to the main screen.");
                        }
                    }
                    break;
                }
            }
            if (!vinFound) {
                System.out.println("Vin not found. Returning to the main screen.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid VIN.");
        }
    }
    public void processLeasedVehicle(){
        System.out.println("You are leasing a vehicle");
        System.out.println("Enter the VIN of the vehicle");
        Scanner scanner = new Scanner(System.in);
        boolean vinWasFound = false;
        if (scanner.hasNextLine()){
            int vinToSearch = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter the following information.");
            System.out.println("Please enter the date.");
            String date = scanner.nextLine();
            System.out.println("Please enter your name");
            String customerName = scanner.nextLine();
            System.out.println("Please enter your email");
            String customerEmail = scanner.nextLine();
            List<Vehicle> vehicles = dealership.getAllVehicles();
            //Iterator is reads over the collection of my list and allows me to modify it without running into the problem before.
            Iterator<Vehicle> iterator = vehicles.iterator();
            while (iterator.hasNext()) {
                Vehicle vehicle = iterator.next();
                if (vinToSearch == vehicle.getVin()) {
                    vinWasFound = true;
                    LeaseContract leaseContract = new LeaseContract(date, customerName, customerEmail, vehicle);
                    leaseContract.getTotalPrice();
                    leaseContract.getMonthlyPayment();

                    System.out.printf("Your total price will be: %.2f \n", leaseContract.getTotalPrice());
                    System.out.printf("Your monthly payment will be: %.2f \n", leaseContract.getMonthlyPayment());

                    System.out.println("Would you like to lease the vehicle? (Yes / No)");
                    if (scanner.hasNextLine()) {
                        String userLeaseChoice = scanner.nextLine();
                        if (userLeaseChoice.equalsIgnoreCase("yes")) {
                            ContractFileManager.writeCustomerLease("LEASE", date, customerName, customerEmail, vehicle, leaseContract.getTotalPrice(),
                                    leaseContract.expectedEndingValue(), leaseContract.leaseFee(), leaseContract.getMonthlyPayment());
                            System.out.println("Car successfully leased. CONGRATS!!!");
                            iterator.remove();
                        } else {
                            System.out.println("Lease Declined. Return to the main page");
                        }
                    }
                }
            }

            if (!vinWasFound) {
                System.out.println("Vin not found. Returning to the main screen.");
            }
        } else {
            System.out.println("Invalid input. Please enter a valid VIN.");
        }
    }
}