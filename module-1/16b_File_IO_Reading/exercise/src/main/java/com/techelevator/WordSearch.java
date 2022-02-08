package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {


    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the fully qualified name of the file that should be searched?");
        String filePath = userInput.nextLine();
        File inputFile = new File(filePath);
        int lineCount = 0;

        System.out.println("What is the search word you are looking for?");
        String searchWord = userInput.nextLine();

        System.out.println("Should the search be case sensitive?");
        String caseSense = userInput.nextLine();

        if (caseSense.equalsIgnoreCase("y")) {
            try (Scanner fileInput = new Scanner(inputFile)) {
                while (fileInput.hasNextLine()) {
                    String lineOfText = fileInput.nextLine();
                    lineCount++;
                    if (!lineOfText.contains(searchWord)) {
                        continue;
                    }
                    System.out.println(lineCount + ") " + lineOfText);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
        if (caseSense.equalsIgnoreCase("n")){
            try (Scanner fileInput = new Scanner(inputFile)) {
                while (fileInput.hasNextLine()) {
                    String lineOfText = fileInput.nextLine();
                    lineCount++;
                    if (!lineOfText.toLowerCase().contains(searchWord.toLowerCase())) {
                        continue;
                    }
                    System.out.println(lineCount + ") " + lineOfText);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }







    }
}
