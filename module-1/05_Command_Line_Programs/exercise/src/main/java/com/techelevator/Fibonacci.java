package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        String numStr = scanner.nextLine();
        int num = Integer.parseInt(numStr);

        if (num <= 0) {
            System.out.println("0,1");
        }
        if (num == 1) {
            System.out.println("0,1,1");
        }
        if (num >= 2)
            System.out.println("0, 1, ");{
            int current = 1;
            int previous = 0;
            int sum = 0;

            while (sum < num) {
                sum = current + previous;
                previous = current;
                current = sum;
                if (sum > num) {
                    break;
                }
                System.out.format("%d, ", sum);
            }
        }


    }


}
