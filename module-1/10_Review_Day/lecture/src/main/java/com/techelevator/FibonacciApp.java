package com.techelevator;

import com.techelevator.math.Fibonacci;

import java.util.List;

public class FibonacciApp {

    public static void main(String[] args) {

        List<Integer> fibUpTo20 = Fibonacci.getFibonacciNumbers(20);
        System.out.println(fibUpTo20);

        List<Integer> fibUpTo100000000 = Fibonacci.getFibonacciNumbers(100000000);
        System.out.println(fibUpTo100000000);

    }
}
