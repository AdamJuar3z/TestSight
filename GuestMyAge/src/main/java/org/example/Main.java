package org.example;

import java.util.Scanner;
// Pseudo code
//They got it right
//== != > < >= >=

public class Main {
    public static void main(String[] args) {
        int age =5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Guess my age! Whole number");

        int userInput = scanner.nextInt();
        boolean playerWasCorrect = false;

        if(userInput == age){
            System.out.println("You git it right!");
            playerWasCorrect = true;
        }
        else if(userInput > age){
            System.out.println("You guest too high");
            playerWasCorrect = false;
        }
        else{
            System.out.println("You guessed too low");
            playerWasCorrect = false;
        }

        if(playerWasCorrect == true){
            System.out.println("Hey you're a winner!");
        }
        if(playerWasCorrect == false);{
            System.out.println("You guessed to incorrectly");
        }


    }
}
