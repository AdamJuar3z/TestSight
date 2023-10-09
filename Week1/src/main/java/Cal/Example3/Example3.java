package Cal.Example3;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double amount;
        double priciple;
        double rate;
        double time;

        System.out.println("Pleae enter the monthly payout amount below: ");
        priciple = scanner.nextDouble();

        System.out.println("Please enter the amount of years you'd like: ");
        time = scanner.nextDouble();

        System.out.println("Please enter interest rate you'd like: ");
        rate = scanner.nextDouble();

        amount = priciple * Math.pow((1 + time / 100 ), rate * 12);

        System.out.printf("To fund an annuity that pays %.2f monthly for %.2f years and earns an expected %.2f interest, you would need to invest %.2f today.", priciple, time, rate, amount);







    }

}




