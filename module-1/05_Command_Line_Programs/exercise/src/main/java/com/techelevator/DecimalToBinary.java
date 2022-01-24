package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        String numStr = scanner.nextLine();
        int num = Integer.parseInt(numStr);
        int i =0;
        String result = "";

        do{

            int num2 = num;
            i = num2 % 2;
            num = num/2;

            result = Integer.toString(i) +result;

        } while (num !=0);
        System.out.print(numStr + " in binary is " +result);
    }
}