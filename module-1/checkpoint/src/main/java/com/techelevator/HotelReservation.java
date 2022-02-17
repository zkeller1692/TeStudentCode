package com.techelevator;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class HotelReservation {

    private String name;
    private int numberOfNights = 0;
    private double estimatedTotal = numberOfNights * 59.99;
    private boolean usedMiniBar = true;
    private boolean requiresCleaning = true;
    private double actualTotal;

    public HotelReservation(String name, int numberOfNights) {
        this.name = name;
        this.numberOfNights = numberOfNights;
    }

    public double getActualTotal(boolean usedMiniBar, boolean requiresCleaning) {
        double miniBarCharge = 12.99;
        double cleaningCharge = 34.99;
        actualTotal = estimatedTotal;
        if (this.usedMiniBar && this.requiresCleaning) {
            actualTotal += (miniBarCharge + (cleaningCharge * 2));
        } else if (usedMiniBar) {
            actualTotal += miniBarCharge;
        } else if (requiresCleaning) {
            actualTotal += cleaningCharge;
        }
        return actualTotal;
    }

    public void loadReservation() {
        try (Scanner inputFile = new Scanner("HotelInput.csv")) {
            while (inputFile.hasNextLine()) {
                String reservation = inputFile.nextLine();
                String[] reservationDataArray = reservation.split("\\,");
                try {
                    String reservationName = reservationDataArray[0];
                    String daysStaying = reservationDataArray[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Unable to make reservation");
                }
            }
        }
    }
}