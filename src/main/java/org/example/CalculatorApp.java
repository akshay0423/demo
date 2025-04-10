package org.example;

public class CalculatorApp {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {

        System.out.println("Sum of 23 & 13 = " + add(23,13));

    }
}