package com.kodilla.spring.calculator;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
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
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 10, b = 5;
        //When
        double addResult = calculator.add(a, b);
        double subResult = calculator.sub(a, b);
        double mulResult = calculator.mul(a, b);
        double divResult = calculator.div(a, b);
        //Then
        Assert.assertEquals(15, addResult, 0.1);
        Assert.assertEquals(5, subResult, 0.1);
        Assert.assertEquals(50, mulResult, 0.1);
        Assert.assertEquals(2, divResult, 0.1);
    }
}
