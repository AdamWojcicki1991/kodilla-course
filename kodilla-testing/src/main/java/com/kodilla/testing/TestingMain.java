package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

import java.util.Random;

public class TestingMain {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        System.out.println("Class SimpleUser - unit test method getUsername()");

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!\n");
        }

        //Set test values to calculate
        int a = RANDOM.nextInt();
        int b = RANDOM.nextInt();

        int addResult = new Calculator().add(a, b);
        int substractResult = new Calculator().substract(a, b);

        System.out.println("Class Calculator - unit test method add()");

        if (addResult == a + b) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!\n");
        }

        System.out.println("Class Calculator - unit test method substract()");

        if (substractResult == a - b) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!\n");
        }
    }
}