package calexample;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter the first number; ");
        System.out.println("Enter first number here.");
        //double firstNumber = scanner.nextDouble();
        double firstNumber = scanner.nextDouble();
        //System.out.println("Enter the second number. ");
        System.out.println("Enter second number.");

        double secondNumber = scanner.nextDouble();
        System.out.println("Possible calculations: (A)dd, (S)ubtract, (M)ultiply, (D)ivide");
        System.out.println("Please select an option:");
        String myAdd = "A";
        String mySubtract = "S";
        String myMultiply = "M";
        String myDivide = "D";
        scanner.nextLine();
        String userPick = scanner.nextLine();

        if (userPick.equalsIgnoreCase("A")) {
            double result = firstNumber + secondNumber;
            System.out.printf("%.2f + %.2f = %.2f", firstNumber, secondNumber, result);
        }
        if (userPick.equalsIgnoreCase("S")) {
            double result = firstNumber - secondNumber;
            System.out.printf("%.2f - %.2f = %.2f", firstNumber, secondNumber, result);
        }
        if (userPick.equalsIgnoreCase("M")) {
            double result = firstNumber * secondNumber;
            System.out.printf("%.2f * %.2f = %.2f");
        }

            if (userPick.equalsIgnoreCase("D")) {
            double result = firstNumber / secondNumber;
                System.out.printf("%.2f / %.2f = %.2f");
            }



        }
    }



