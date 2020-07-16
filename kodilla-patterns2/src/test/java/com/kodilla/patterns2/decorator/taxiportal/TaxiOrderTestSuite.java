package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(40), cost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(37), cost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildSeatGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(29), cost);
    }

    @Test
    public void testUberWithTwoChildSeatGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new UberNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        order = new ChildSeatDecorator(order);
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new VipCarDecorator(order);
        order = new ChildSeatDecorator(order);
        System.out.println(order.getCost());
        //When
        BigDecimal cost = order.getCost();
        //Then
        assertEquals(new BigDecimal(52), cost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new VipCarDecorator(order);
        order = new ChildSeatDecorator(order);
        System.out.println(order.getDescription());
        //When
        String description = order.getDescription();
        //Then
        assertEquals("Drive a course by Taxi Network variant VIP + child seat", description);
    }
}
