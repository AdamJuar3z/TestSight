package org.example;

public class Main {
    public static void main(String[] args) {
        //What happens if I just make a dealership and don't use the DealershipFileManager?
        //Is there anything stopping me from doing that?
        Dealership dealership = DealershipFileManager.getDealership();

        UserInterface userInterface = new UserInterface(dealership);

        userInterface.display();
    }
}