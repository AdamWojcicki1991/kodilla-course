package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    private static int testCounter = 0;

    private static List<Integer> numbers(int size) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    @Before
    public void before() {
        testCounter++;
        System.out.println("Test Case#" + testCounter + " begin");
    }

    @After
    public void after() {
        System.out.println("Test Case#" + testCounter + " end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> evensResult = oddNumbersExterminator.exterminate(numbers);
        //Then
        Assert.assertTrue(evensResult.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> numbers = numbers(20);
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> evensResult = oddNumbersExterminator.exterminate(numbers);
        //Then
        for (Integer evenNumber : evensResult) {
            Assert.assertTrue(evenNumber % 2 == 0);
        }
    }
}
