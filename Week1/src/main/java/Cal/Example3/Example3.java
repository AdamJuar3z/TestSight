package Cal.Example3;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter principal amount bellow: ");
        double p = scanner.nextDouble();

        System.out.print("Enter annual interest rate: ");
        double r = scanner.nextDouble();

        System.out.println("Enter compound interest: ");
        int cI = scanner.nextInt();

        System.out.print("Enter time period in years: ");
        int y = scanner.nextInt();

        // A = P(1 + r/n)(n)(t):

// A = 10,000.00(1 + 0.03875/12)(12)(7.5) == a(p + i) = p(1 + ( r
        double iR = r / 100;
        double amount = p * Math.pow((1 + (iR / cI)),
                (cI * y));

        System.out.printf("After %d years, your investment will grow to: $%.2f\n", y, amount);


        scanner.close();
    }
}




