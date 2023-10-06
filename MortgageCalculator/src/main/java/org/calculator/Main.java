package org.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Mortgage Calculator, please enter information below.");


        System.out.println("Please enter the Principle.");
        double userPrinciple = scanner.nextDouble();

        System.out.println("Please enter the Interest Rate.");
        double userInterest = scanner.nextDouble();

        System.out.println("Please enter the loan length.");
        int userLoanLength = scanner.nextInt();

        double usersMonthInterest = (userInterest / 12) / 100;
        int amountOfPayments = userLoanLength * 12;

        double monthlyPayment = userPrinciple * (usersMonthInterest * Math.pow(1 + usersMonthInterest, amountOfPayments)) /
                (Math.pow(1 + usersMonthInterest, amountOfPayments) - 1);
        double userTotalInt = (monthlyPayment * amountOfPayments) - userPrinciple;

        System.out.printf("Monthly Payment (M): $%.2f\n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f\n", userTotalInt);
        scanner.close();

    }
}
