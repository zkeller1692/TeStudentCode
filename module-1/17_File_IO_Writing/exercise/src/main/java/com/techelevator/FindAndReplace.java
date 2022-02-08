package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replaceWord = userInput.nextLine();

        System.out.println("What is the Source file?");
        String sourceFile = userInput.nextLine();
        File inputFile = new File(sourceFile);

        System.out.println("What is the destination file?");
        String destinationFile = userInput.nextLine();

        try (Scanner inputFileScan = new Scanner(inputFile);
        PrintWriter outputFile = new PrintWriter(destinationFile)){
            while(inputFileScan.hasNextLine()){
                String lineOfText = inputFileScan.nextLine();
                outputFile.println(lineOfText.replaceAll(searchWord, replaceWord));
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }


    }
}
