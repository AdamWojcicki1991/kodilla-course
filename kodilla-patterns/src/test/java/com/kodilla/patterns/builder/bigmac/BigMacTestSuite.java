package com.kodilla.patterns.builder.bigmac;

import org.junit.*;

import static com.kodilla.patterns.builder.bigmac.IngredientsType.*;
import static com.kodilla.patterns.builder.bigmac.RollType.BUN_WITH_SESAME;
import static com.kodilla.patterns.builder.bigmac.SauceType.BARBECUE;

public class BigMacTestSuite {
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
    public void testBigMacBuilder() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .roll(BUN_WITH_SESAME)
                .burgers(12)
                .sauce(BARBECUE)
                .ingredients(ONION)
                .ingredients(BACON)
                .ingredients(CHILI_PEPPERS)
                .ingredients(MUSHROOMS)
                .ingredients(CHEESE)
                .build();
        System.out.println(bigMac);
        //When
        RollType whichRoll = bigMac.getRoll();
        int howManyBurgers = bigMac.getBurgers();
        SauceType whichSauce = bigMac.getSauce();
        int howManyIngredients = bigMac.getIngredients().size();
        //Then
        Assert.assertEquals(BUN_WITH_SESAME, whichRoll);
        Assert.assertEquals(12, howManyBurgers);
        Assert.assertEquals(BARBECUE, whichSauce);
        Assert.assertEquals(5, howManyIngredients);
    }
}
