package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the length: ");
		String lengthStr = scanner.nextLine();
		double length = Double.parseDouble(lengthStr);


		System.out.print("Is the measurement in (m)eter, or (f)eet? ");
		String fOrC = scanner.nextLine();
		double meter = 0;
		double feet= 0;

		if (fOrC.equalsIgnoreCase("f")){
			meter = length * 0.3048;
			System.out.format("%3.1ff is %3.1fm.%n",length, meter);
		}
		if (fOrC.equalsIgnoreCase("m")) {
			feet = length * 3.2808399;
			System.out.format("%3.1fm is %3.1ff.%n", length, feet);
		}
	}

}
