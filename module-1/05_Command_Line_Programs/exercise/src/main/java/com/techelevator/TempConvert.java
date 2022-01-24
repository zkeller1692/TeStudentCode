package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the temperature: ");
		String temperatureStr = scanner.nextLine();
		double temp = Double.parseDouble(temperatureStr);


		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String fOrC = scanner.nextLine();
		double tempC = 0;
		double tempF= 0;

		if (fOrC.equalsIgnoreCase("f")){
			 tempC = (temp-32)/1.8;
			 System.out.format("%3.0fF is %3.0fC.%n",temp, tempC);
		}
		if (fOrC.equalsIgnoreCase("c")){
			tempF = temp * 1.8 + 32;
			System.out.format("%3.0fC is %3.0fF.%n",temp, tempF);
		}

	}

}
