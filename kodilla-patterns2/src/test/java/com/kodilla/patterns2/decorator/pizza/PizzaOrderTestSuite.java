package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaWithAdditionalCheeseKebabHamGetCost() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new CheeseDecorator(order);
        order = new KebabDecorator(order);
        order = new HamDecorator(order);
        System.out.println(order.getCost());
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(35), cost);
    }

    @Test
    public void testPizzaWithAdditionalCheeseKebabHamGetDescription() {
        //Given
        PizzaOrder order = new BasicPizzaOrder();
        order = new CheeseDecorator(order);
        order = new KebabDecorator(order);
        order = new HamDecorator(order);
        System.out.println(order.getDescription());
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Pizza order with bottom, tomato sauce, cheese + cheese + kebab + ham", description);
    }
}
