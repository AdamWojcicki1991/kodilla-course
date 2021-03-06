package com.kodilla.stream.array;

import org.junit.*;

public class ArrayOperationsTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testGetAverage() {
        //Given
        int[] testArray = new int[20];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i + 1;
        }

        //When
        double average = ArrayOperations.getAverage(testArray);

        //Then
        Assert.assertEquals(10.5, average, 0.1);
    }

    @Test
    public void testGetAverageForEmptyArray() {
        //Given
        int[] testArray = new int[0];

        //When
        double average = ArrayOperations.getAverage(testArray);

        //Then
        Assert.assertEquals(0, average, 0.1);
    }
}
