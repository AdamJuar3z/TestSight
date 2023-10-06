package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Rental Car Calculator, what is your pick up date? Monday-Friday");
        String userDate = scanner.nextLine();

        System.out.println("What is your age?");
        int withAge = scanner.nextInt();

        System.out.println("How many days would you like to rent the car?");
        int rentalDays = scanner.nextInt();

        System.out.println("Would you like to rent a toll tag? True / False?");
        boolean withTollTag = scanner.nextBoolean();

        System.out.println("Would you like a GPS? True / False");
        boolean withGps = scanner.nextBoolean();

        System.out.println("Would you like roadside assistance? True / False");
        boolean roadAssistance = scanner.nextBoolean();

        double userCostMinDay = 29.99 * rentalDays;
        if (withTollTag) {
            userCostMinDay += 3.95 * rentalDays;
        }
        if (withGps) {
            userCostMinDay += 2.95 * rentalDays;
        }
        if (roadAssistance) {
            userCostMinDay += 3.95 * rentalDays;
        }
        if (withAge < 25) {
            userCostMinDay *= 1.3;
        }
        System.out.println("Date of pick up. " + userDate);
        System.out.println("Base car rental cost: $" + (29.99 + rentalDays));
        System.out.println("Options cost: $" + (userCostMinDay - (29.99 * rentalDays)));
        System.out.println("Underage driver surcharge: $" + ((withAge < 25) ? (userCostMinDay - (29.99 * rentalDays)) * 0.3 : 0));
        System.out.println("Total cost: $" + userCostMinDay);

        scanner.close();


        //1.create a scanner
        //2. Prompt user for pick up date
        //        **Create a string variable to hold this
        //        **nextLine() would be a good method
        //3. Prompt user for age
        //4. Prompt user for how many days do you want to rent the car
        //5 ~ Electronic toll tag
        //         **boolean hasElectronicTollTag
        //6. ~ GPS
        //7. ~ Roadside assistance
        //8. Multiply 29.99 x the number of days
        //9. If they want electronic toll tag, add 3.95 x number of days
        //10. if they want GPS, add 2.95 x number of days
        //11. if they want roadside assistance, add 3.95 x number of days
        //12. See if they are under 25, if they are, multiply the total cost by 1.3 if they are 25 or over, do nothing
        //13.Show the basic car rental, options cost, underage driver surcharge, and total cost

    }}

