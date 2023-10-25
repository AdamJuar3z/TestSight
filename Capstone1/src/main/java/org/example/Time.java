package org.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Time {
    public static void monthToDate(HashMap<String, ArrayList<Transactions>> mtd) {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;

        for (String customer : mtd.keySet()) {
            System.out.println("Transactions for " + customer + ":");
            for (Transactions transaction : mtd.get(customer)) {
                int transactionMonth = Integer.parseInt(transaction.date.split("/")[0]);

                if (transactionMonth == currentMonth) {
                    System.out.println("Type: " + transaction.type + ", Amount: $" + transaction.amount +
                            ", Description: " + transaction.description +
                            ", Date: " + transaction.date +
                            ", Time: " + transaction.time);
                }
            }
        }
    }

    public static void previousMonth(HashMap<String, ArrayList<Transactions>> pm){
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int previousMonth = (currentMonth - 1 + 12) % 12;

        for (String customer : pm.keySet()) {
            System.out.println("Previous Month Transactions for " + customer + ":");
            for (Transactions transaction : pm.get(customer)) {

                int transactionMonth = Integer.parseInt(transaction.date.split("/")[0]);

                if (transactionMonth == previousMonth) {
                    System.out.println("Type: " + transaction.type + ", Amount: $" + transaction.amount +
                            ", Description: " + transaction.description +
                            ", Date: " + transaction.date +
                            ", Time: " + transaction.time);
                }
            }
        }
    }
    public static void yearToDate(HashMap<String, ArrayList<Transactions>> ytd) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        for (String customer : ytd.keySet()) {
            System.out.println("Year to Date Transactions for " + customer + ":");
            for (Transactions transaction : ytd.get(customer)) {

                int transactionYear = Integer.parseInt(transaction.date.split("/")[2]);

                if (transactionYear == currentYear) {
                    System.out.println("Type: " + transaction.type + ", Amount: $" + transaction.amount +
                            ", Description: " + transaction.description +
                            ", Date: " + transaction.date +
                            ", Time: " + transaction.time);
                }
            }
        }
    }
    public static void previousYear(HashMap<String, ArrayList<Transactions>> py) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        for (String customer : py.keySet()) {
            System.out.println("Previous Year Transactions for " + customer + ":");
            for (Transactions transaction : py.get(customer)) {
                int transactionYear = Integer.parseInt(transaction.date.split("/")[2]);

                if (transactionYear == currentYear - 1) {
                    System.out.println("Type: " + transaction.type + ", Amount: $" + transaction.amount +
                            ", Description: " + transaction.description +
                            ", Date: " + transaction.date +
                            ", Time: " + transaction.time);
                }
            }
        }
    }
}