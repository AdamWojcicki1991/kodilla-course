package com.kodilla.patterns.factory.tasks;

import org.junit.*;

import static com.kodilla.patterns.factory.tasks.TaskType.*;

public class TaskFactoryTestSuite {
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
    public void testFactoryShoppingWithExecution() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.makeTask(SHOPPING);
        shopping.executeTask();
        //Then
        Assert.assertEquals("SHOPPING TASK", shopping.getTaskName());
        Assert.assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingWithExecution() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.makeTask(PAINTING);
        painting.executeTask();
        //Then
        Assert.assertEquals("PAINTING TASK", painting.getTaskName());
        Assert.assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingWithExecution() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.makeTask(DRIVING);
        driving.executeTask();
        //Then
        Assert.assertEquals("DRIVING TASK", driving.getTaskName());
        Assert.assertEquals(true, driving.isTaskExecuted());
    }

    @Test
    public void testFactoryShoppingWithOutExecution() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.makeTask(SHOPPING);
        //Then
        Assert.assertEquals("SHOPPING TASK", shopping.getTaskName());
        Assert.assertEquals(false, shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingWithOutExecution() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.makeTask(PAINTING);
        //Then
        Assert.assertEquals("PAINTING TASK", painting.getTaskName());
    }

    @Test
    public void testFactoryDrivingWithOutExecution() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.makeTask(DRIVING);
        //Then
        Assert.assertEquals("DRIVING TASK", driving.getTaskName());
    }
}
