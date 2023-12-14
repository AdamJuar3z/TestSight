/*
package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {
//    //Arrange
   @Test
    public void test_GetTotal_Price(){
        SalesContract salesContract = new SalesContract("10/22/20", "Diana",
                new Vehicle(10234, 2020, "Ford", "Bronco", "SUV", "Black",
                        100, 10000), "@yahoo.com", true);
        SalesContract salesContract2 = new SalesContract("10/22/20", "Diana",
                new Vehicle(10234, 2020, "Ford", "Bronco", "SUV", "Black",
                        100, 20000), "@yahoo.com", false);
        SalesContract salesContract3 = new SalesContract("10/22/20", "Diana",
                new Vehicle(10234, 2020, "Ford", "Bronco", "SUV", "Black",
                        100, 10000), "@yahoo.com", true);

        var interestRate = .0425 / 12;


           ///////////////
        double expectedPrice = (48*(10000 * interestRate * Math.pow(1 + interestRate, 48))/(Math.pow(1 + interestRate, 48)-1)) + 100 + 495 + 500;
        double actual = salesContract.getTotalPrice();

        BigDecimal expectedPrice1 = new BigDecimal(expectedPrice);
        BigDecimal acutualDecimal = new BigDecimal(actual);
        expectedPrice1 = expectedPrice1.setScale(2, BigDecimal.ROUND_HALF_UP);
        acutualDecimal = acutualDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        /////////////////
        
        double expectedPrice2 = 20000 + 100 + 495 + 1000;
        double actual2 = salesContract2.getTotalPrice();

        BigDecimal expectedPrice2a = new BigDecimal(expectedPrice2);
        BigDecimal actualDecimal2a = new BigDecimal(actual2);
        expectedPrice2a = expectedPrice2a.setScale(2, BigDecimal.ROUND_HALF_UP);
        actualDecimal2a = actualDecimal2a.setScale(2,BigDecimal.ROUND_HALF_UP);


        /////////////
        double expectedPrice3 = (24*(10000 * interestRate * Math.pow(1 + interestRate, 24))/(Math.pow(1 + interestRate, 24)-1)) + 100 + 295 + 500;
        double actual3 = salesContract3.getTotalPrice();

        BigDecimal expectedPrice3a = new BigDecimal(expectedPrice3);
        BigDecimal actualDecimal3a = new BigDecimal(actual3);
        expectedPrice3a = expectedPrice3a.setScale(2, BigDecimal.ROUND_HALF_UP);
        actualDecimal3a = actualDecimal3a.setScale(2, BigDecimal.ROUND_HALF_UP);

        assertEquals(expectedPrice1, acutualDecimal);
        assertEquals(expectedPrice2a, actualDecimal2a);
        assertEquals(expectedPrice3a, actualDecimal3a);



    }
    //s1)Create a vehicle price = 100000
    //s2) create a sales contract
    //s3) hand it to vehicle
    //s4) run getTotalPrice
    //s5) compare on what you expected the output would be
    //Act
    //Assert

*/
