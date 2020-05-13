package com.kodilla.patterns.singleton;

import org.junit.*;

public class LoggerTestSuite {
    private static int testCounter;

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
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("Hello, World");
        //When
        String lastLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Hello, World", lastLog);
    }
}
