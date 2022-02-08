package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.println("What is the destination file?");
		String destinationFile = userInput.nextLine();
		int count = 0;

		try (PrintWriter outputFile = new PrintWriter(destinationFile)){
			do{count++;
				if(count %3 == 0 && count % 5 ==0){
				outputFile.println("FizzBuzz");
			}
				else if (count % 3 == 0){
					outputFile.println("Fizz");
				}
				else if (count % 5 == 0){
					outputFile.println("Buzz");
				}
				else{ outputFile.println(count);}
			}while(count <300);
		}catch (FileNotFoundException e){
			System.out.println("File not found");
		}
	}

}
