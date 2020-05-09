package com.kodilla.good.patterns.food;

import java.time.LocalDateTime;

public class SupplierOrderRepository implements OrderRepository {

    @Override
    public void createOrder(Supplier supplier, Product product, LocalDateTime orderDate) {
        System.out.println("Creating order for " + supplier + ", Product: " + product + ", Amount: " + product.getQuantity() + " with order date " + orderDate);
    }
}
