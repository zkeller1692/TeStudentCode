package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalCoachSeats = totalCoachSeats;
        this.totalFirstClassSeats = totalFirstClassSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableFirstClassSeats() {
        return (totalFirstClassSeats - bookedFirstClassSeats);
    }

    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            totalNumberOfSeats += bookedFirstClassSeats;
            if (totalNumberOfSeats <= (totalCoachSeats + totalFirstClassSeats)) {
                return true;
            }
            return false;
        } else {
            totalNumberOfSeats += bookedCoachSeats;
            if (totalNumberOfSeats <= (totalFirstClassSeats + totalCoachSeats)) {
                return true;
            }
        } return false;
    }
}
