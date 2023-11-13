package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Dealership dealership = DealershipFileManager.getDealership();

        UserInterface userInterface = new UserInterface(dealership);

        userInterface.display();
    }
}