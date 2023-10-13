package my.Example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        String Customer01 = "-Adam Juarez-";
        String birthDate = "-05/09/1995-";
        String birthPlace = "-Detroit-";
        String address = "-1234 Somewhere Street-";
        System.out.println(Customer01 + birthDate + birthPlace + address);
        // int stands for integer and stores whole numbers
        int ticketsSold = 10000;
        // double stores fractions if needed
        double productPrice = 10.57;
        double stadiumTicketsSold = 50000;
        double ticketCost = 35;
        double moneyIMade = stadiumTicketsSold * ticketCost;
        System.out.println(moneyIMade);
        stadiumTicketsSold = 300000;
        ticketCost = 40;
        System.out.println(stadiumTicketsSold * ticketCost);
        // float is also numbers with fractions (float must have an f at the end of the variable) Example:
        float itemPrice = 10.5f;
        float txTaxes = 6.25f;
        System.out.println(itemPrice * txTaxes);
        // binary choice or true or false situation
        boolean isPremiumMember = true;
        boolean isGoldMemner = false;

        String whatIsLove = " What is Love ";
        String babyDontHurtMe = " Baby don't hurt me ";
        String noMo = " No more ";
        System.out.println(whatIsLove + babyDontHurtMe + noMo);

        
        


        



        }


    }

