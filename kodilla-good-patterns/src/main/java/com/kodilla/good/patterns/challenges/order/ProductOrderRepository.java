package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDateTime;

public class ProductOrderRepository implements OrderRepository {

    @Override
    public void createOrder(User user, Product product, LocalDateTime orderDate) {
        System.out.println("Creating order for " + user + " his product " + product + " with order date " + orderDate);
    }
}
