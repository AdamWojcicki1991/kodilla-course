package com.kodilla.spring.portfolio;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {
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
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.getToDoList().getTasksList().add("Task 1 is in ToDoList");
        board.getInProgressList().getTasksList().add("Task 2 is in InProgressList");
        board.getDoneList().getTasksList().add("Task 3 is in DoneList");
        //Then
        Assert.assertEquals("Task 1 is in ToDoList", board.getToDoList().getTasksList().get(0));
        Assert.assertEquals("Task 2 is in InProgressList", board.getInProgressList().getTasksList().get(0));
        Assert.assertEquals("Task 3 is in DoneList", board.getDoneList().getTasksList().get(0));
    }
}
