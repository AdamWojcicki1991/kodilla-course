package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> evensResult = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing " + evensResult);
        //Then
        Assert.assertTrue(evensResult.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> evensResult = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing " + evensResult);
        //Then
        for (Integer evenNumber : evensResult) {
            Assert.assertTrue(evenNumber % 2 == 0);
        }
    }
}