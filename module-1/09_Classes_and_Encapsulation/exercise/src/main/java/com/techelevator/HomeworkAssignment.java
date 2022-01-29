package com.techelevator;

import java.security.PrivateKey;

public class HomeworkAssignment {

    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;


    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        if ((1.0 * earnedMarks / possibleMarks * 100) >= 90) {
            return "A";
        }
        if ((1.0 * earnedMarks / possibleMarks * 100) <= 89 && (1.0 * earnedMarks / possibleMarks *100) >= 80) {
            return "B";
        } else if ((1.0 * earnedMarks / possibleMarks * 100) <= 79 && (1.0 * earnedMarks / possibleMarks * 100) >= 70) {
            return "C";
        } else if ((1.0 * earnedMarks / possibleMarks *100) <= 69 && (1.0 * earnedMarks / possibleMarks * 100) >= 60) {
            return "D";
        }
        else return "F";
    }

}

