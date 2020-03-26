package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        double x = 3;
        double y = 2;

        try {
            System.out.println("\n" + secondChallenge.probablyIWillThrowException(x, y) + "\n");
        } catch (Exception e) {
            System.out.println("\nCondition (x >= 2 || x < 1 || y == 1.5) fulfilled ! We have an exception !\n");
        } finally {
            System.out.println("You put to method two arguments (x = " + x + ", y = " + y + ")");
        }
    }
}
