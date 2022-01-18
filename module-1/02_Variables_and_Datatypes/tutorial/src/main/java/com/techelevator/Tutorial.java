package com.techelevator;

public class Tutorial {
    public static void main(String[] args) {
        /******************************************************************************/
        // Step 1: Declare and initialize variables
        /******************************************************************************/
        double costOfDinner = 120.00;
        int tipPercent = 18;
        int numberOfGuests = 4;

        // Greet the user
        System.out.println("********************************************");
        System.out.println("*** Welcome to the Restaurant Calculator ***");
        System.out.println("********************************************");
        System.out.println("Cost of dinner: $" + costOfDinner);

        /******************************************************************************/
        // Step 2: Calculate the sales tax and tip
        /******************************************************************************/
        final double SALES_TAX_PERCENT = 7.5;
        double taxAmount;
        taxAmount = SALES_TAX_PERCENT / 100 * costOfDinner;
        double tipAmount = tipPercent / 100.0 * costOfDinner;

        // Display the tax and tip
        System.out.println("Tax: $" + taxAmount);
        System.out.println("Tip: $" + tipAmount);

        /******************************************************************************/
        // Step 3: Calculate the amount per person
        /******************************************************************************/






        /******************************************************************************/
        // Step 4: Given the total number of dessert pieces, determine the number each
        //      guest gets, and the number left over after each guest eats their pieces.
        /******************************************************************************/







        System.out.println("********************************************");
        System.out.println("** Thanks for using Restaurant Calculator **");
        System.out.println("********************************************");

    }
}
