package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.*;

public class UserTestSuite {
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
    public void testDefaultSharingStrategies() {
        //Given
        User adam = new Millenials("Adam Wójcicki");
        User john = new YGeneration("John Newman");
        User michael = new ZGeneration("Michael Jordan");

        //When
        String adamSharePostFrom = adam.sharePost();
        System.out.println("Adam posts from: " + adamSharePostFrom);
        String johnSharePostFrom = john.sharePost();
        System.out.println("John posts from: " + johnSharePostFrom);
        String michaelSharePostFrom = michael.sharePost();
        System.out.println("Michael posts from: " + michaelSharePostFrom);

        //Then
        Assert.assertEquals("Facebook", adamSharePostFrom);
        Assert.assertEquals("Twitter", johnSharePostFrom);
        Assert.assertEquals("Snapchat", michaelSharePostFrom);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User adam = new Millenials("Adam Wójcicki");

        //When
        String adamSharePostFrom = adam.sharePost();
        System.out.println("Adam posts from: " + adamSharePostFrom);
        adam.setSocialPublisher(new TwitterPublisher());
        adamSharePostFrom = adam.sharePost();
        System.out.println("Adam posts from: " + adamSharePostFrom);

        //Then
        Assert.assertEquals("Twitter", adamSharePostFrom);
    }
}
