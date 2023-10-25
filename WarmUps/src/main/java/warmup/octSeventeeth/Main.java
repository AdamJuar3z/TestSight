package warmup.octSeventeeth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Please enter te first number");
            int number1 = scanner.nextInt();

            System.out.println("Please enter second number.");
            int number2 = scanner.nextInt();

            double result = (double) number1 / number2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException ex) {

            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception ex) {

            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}
