package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How's the weather today? Sunny? Cloudy? Rainy? ");
        String mySunny = "Sunny;
        String myCloudy = "Cloudy";
        String myRainy = "Rainy";
        String anyElse = "Else";
        String userPick = scanner.nextLine();

        if(userPick.equalsIgnoreCase("Sunny")) {
            System.out.println("It's a great day for outdoor activities!");
        }
        else if(userPick.equalsIgnoreCase("Cloudy")) {
            System.out.println("The weather is a bit uncertain.");
        }
        else if(userPick.equalsIgnoreCase("Rainy")) {
            System.out.println("Don't forget your umbrella!");
        }
        else {
            System.out.println("Sorry, I'm not sure about that weather type.");
        }

        }
        }




