package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        double a = 3;
        double b = 0;

        try {
            double result = firstChallenge.divide(a, b);
            System.out.println("\nResult of division is " + result + "\n");
        } catch (ArithmeticException e) {
            System.out.println("\nWe can not divide by 0 " + e + "\n");
        } finally {
            System.out.println("You divided " + a + " by " + b);
        }
    }
}
