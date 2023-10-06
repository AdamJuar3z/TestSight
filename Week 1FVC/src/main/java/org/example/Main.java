package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your future value calculator! Please provide deposit amount below.");
        double  userDeposit = scanner.nextDouble();

        System.out.println("What interest rate would you like?");
        double userInterest = scanner.nextDouble();

        System.out.println("How many years on your loan would you like?");
        double userYears = scanner.nextDouble();

        // FV = P(1 + r/n)^(n*t)
        //fv = Future Value
        double base = (1 + (userInterest /365));
        double expo = 365 * userYears;

        double fv = userDeposit * Math.pow(base, expo);


        System.out.println(fv);



//        FV is the future value of the deposit.
  //      P is the initial deposit amount.
    //    r is the annual interest rate (in decimal form, e.g., 0.0175 for 1.75%).
      //  n is the number of times the interest is compounded per year (assuming daily compounding, n would be 365).
        //t is the number of years the money is invested for.





    }
}
