package org.example;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        try {
            System.out.println(calculator.prime_factorization(-12));
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e);
        }
    }
}