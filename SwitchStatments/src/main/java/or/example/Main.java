package or.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What is your favorite day of the week?");
        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();
        userInput = userInput.toLowerCase();

        switch(userInput){
            case "monday":
                System.out.println("That's weird bro.");
                break;
            case "tuesday":
                System.out.println("That's a bit better, the week is starting");
                break;
            case "wednesday":
                System.out.println("It's hump day.");
                break;
            case "thursday":
                System.out.println("Its friday eve!");
                break;
            case "friday":
                System.out.println("Yay its almost the weekend");
                break;
            case "saturday":
                System.out.println("Go home and relax");
                break;
            case "sunday":
                System.out.println("That's not a day of the week");
                break;
            default:






        }







    }
}
