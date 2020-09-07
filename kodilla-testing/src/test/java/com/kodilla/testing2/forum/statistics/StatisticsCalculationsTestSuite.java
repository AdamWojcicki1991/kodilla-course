package com.kodilla.testing2.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsCalculationsTestSuite {
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
    public void testShouldWorkWhenPostsCountIsZero() {
        //Given
        Statistics statistics = mock(Statistics.class);
        int postsCount = 0;
        int commentsCount = 10;
        List<String> usersList = new ArrayList<>();
        usersList.add("Andrew");
        usersList.add("Monica");
        usersList.add("Andre");
        when(statistics.usersNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postsCount);

        StatisticsCalculations statisticsCalculations = new StatisticsCalculations();

        //When
        statisticsCalculations.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(3, statisticsCalculations.getAverageCommentsPerUsers(), 0.1);
        Assert.assertEquals(0, statisticsCalculations.getAveragePostsPerUsers(), 0.1);
        Assert.assertEquals(0, statisticsCalculations.getAverageCommentsPerPost(), 0.1);
    }

    @Test
    public void testShouldWorkWhenPostsCountIsThousend() {
        //Given
        Statistics statistics = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 1000;
        List<String> usersList = new ArrayList<>();
        usersList.add("Andrew");
        usersList.add("Monica");
        usersList.add("Andre");
        when(statistics.usersNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postsCount);

        StatisticsCalculations statisticsCalculations = new StatisticsCalculations();

        //When
        statisticsCalculations.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(333, statisticsCalculations.getAverageCommentsPerUsers(), 0.1);
        Assert.assertEquals(333, statisticsCalculations.getAveragePostsPerUsers(), 0.1);
        Assert.assertEquals(1, statisticsCalculations.getAverageCommentsPerPost(), 0.1);
    }

    @Test
    public void testShouldWorkWhenCommentsCountIsZero() {
        //Given
        Statistics statistics = mock(Statistics.class);
        int postsCount = 10;
        int commentsCount = 0;
        List<String> usersList = new ArrayList<>();
        usersList.add("Andrew");
        usersList.add("Monica");
        usersList.add("Andre");
        when(statistics.usersNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postsCount);

        StatisticsCalculations statisticsCalculations = new StatisticsCalculations();

        //When
        statisticsCalculations.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, statisticsCalculations.getAverageCommentsPerUsers(), 0.1);
        Assert.assertEquals(3, statisticsCalculations.getAveragePostsPerUsers(), 0.1);
        Assert.assertEquals(0, statisticsCalculations.getAverageCommentsPerPost(), 0.1);
    }

    @Test
    public void testShouldWorkWhenCommentsCountIsLessThanPostsCount() {
        //Given
        Statistics statistics = mock(Statistics.class);
        int postsCount = 100;
        int commentsCount = 10;
        List<String> usersList = new ArrayList<>();
        usersList.add("Andrew");
        usersList.add("Monica");
        usersList.add("Andre");
        when(statistics.usersNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postsCount);

        StatisticsCalculations statisticsCalculations = new StatisticsCalculations();

        //When
        statisticsCalculations.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(3, statisticsCalculations.getAverageCommentsPerUsers(), 0.1);
        Assert.assertEquals(33, statisticsCalculations.getAveragePostsPerUsers(), 0.1);
        Assert.assertEquals(0.1, statisticsCalculations.getAverageCommentsPerPost(), 0.1);
    }

    @Test
    public void testShouldWorkWhenCommentsCountIsGraterThanPostsCount() {
        //Given
        Statistics statistics = mock(Statistics.class);
        int postsCount = 10;
        int commentsCount = 100;
        List<String> usersList = new ArrayList<>();
        usersList.add("Andrew");
        usersList.add("Monica");
        usersList.add("Andre");
        when(statistics.usersNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postsCount);

        StatisticsCalculations statisticsCalculations = new StatisticsCalculations();

        //When
        statisticsCalculations.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(33, statisticsCalculations.getAverageCommentsPerUsers(), 0.1);
        Assert.assertEquals(3, statisticsCalculations.getAveragePostsPerUsers(), 0.1);
        Assert.assertEquals(10, statisticsCalculations.getAverageCommentsPerPost(), 0.1);
    }

    @Test
    public void testShouldWorkWhenUsersCountIsZero() {
        //Given
        Statistics statistics = mock(Statistics.class);
        int postsCount = 10;
        int commentsCount = 10;
        List<String> usersList = new ArrayList<>();
        when(statistics.usersNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postsCount);

        StatisticsCalculations statisticsCalculations = new StatisticsCalculations();

        //When
        statisticsCalculations.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(0, statisticsCalculations.getAverageCommentsPerUsers(), 0.1);
        Assert.assertEquals(0, statisticsCalculations.getAveragePostsPerUsers(), 0.1);
        Assert.assertEquals(1, statisticsCalculations.getAverageCommentsPerPost(), 0.1);
    }

    @Test
    public void testShouldWorkWhenUsersCountIsHundred() {
        //Given
        Statistics statistics = mock(Statistics.class);
        int postsCount = 1000;
        int commentsCount = 1000;
        List<String> usersList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            usersList.add("Andrew" + i);
        }
        when(statistics.usersNames()).thenReturn(usersList);
        when(statistics.commentsCount()).thenReturn(commentsCount);
        when(statistics.postsCount()).thenReturn(postsCount);

        StatisticsCalculations statisticsCalculations = new StatisticsCalculations();

        //When
        statisticsCalculations.calculateAdvStatistics(statistics);
        //Then
        Assert.assertEquals(10, statisticsCalculations.getAverageCommentsPerUsers(), 0.1);
        Assert.assertEquals(10, statisticsCalculations.getAveragePostsPerUsers(), 0.1);
        Assert.assertEquals(1, statisticsCalculations.getAverageCommentsPerPost(), 0.1);
    }
}
