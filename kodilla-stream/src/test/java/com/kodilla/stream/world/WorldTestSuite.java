package com.kodilla.stream.world;

import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

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
    public void testGetPeopleQuantity() {
        //Given
        List<Country> countriesOfEurope = new ArrayList<>();
        countriesOfEurope.add(new Country("Poland", new BigDecimal(38000000)));
        countriesOfEurope.add(new Country("Germany", new BigDecimal(82423000)));
        countriesOfEurope.add(new Country("Spain", new BigDecimal(40397000)));
        List<Country> countriesOfAsia = new ArrayList<>();
        countriesOfAsia.add(new Country("China", new BigDecimal(1314500000)));
        countriesOfAsia.add(new Country("India", new BigDecimal(11000000)));
        countriesOfAsia.add(new Country("Indonesia", new BigDecimal(245500000)));
        List<Country> countriesOfAfrica = new ArrayList<>();
        countriesOfAfrica.add(new Country("Nigeria", new BigDecimal(131860000)));
        countriesOfAfrica.add(new Country("Bangladesh", new BigDecimal(147366000)));
        countriesOfAfrica.add(new Country("Ethiopia", new BigDecimal(74778000)));
        List<Continent> continents = new ArrayList<>();
        continents.add(new Continent("Europe", countriesOfEurope));
        continents.add(new Continent("Asia", countriesOfAsia));
        continents.add(new Continent("Africa", countriesOfAfrica));

        World world = new World(continents);

        //When
        BigDecimal quantityOfPeopleInTheWorld = world.getPeopleQuantity();

        //Then
        BigDecimal expectedQuantityOfPeopleInTheWorld = new BigDecimal("2085824000");
        Assert.assertEquals(expectedQuantityOfPeopleInTheWorld, quantityOfPeopleInTheWorld);
    }
}
