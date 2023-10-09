package Cal.Example3;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// MPO stands for Monthly Pay Value
        System.out.println("Welcome to the present value calculator!");
        System.out.println("Please enter present value.");
        double userMPV = scanner.nextDouble();
// AIR stands for Annual Interest rate
        System.out.println("Please enter the interest.");
        double userAIR = scanner.nextDouble();
// NOY stands for Number Of Years
        System.out.println("Please enter the number of years.");
        double userNOY = scanner.nextDouble();

        double monthlyInterestRate = (1 + (userAIR / 365));
        double totalPayments = 365  * userNOY;

        double presentValue = userMPV * Math.pow(monthlyInterestRate, totalPayments);

        System.out.println(presentValue);

    }}




