package com.kodilla.good.patterns.food;

import java.time.LocalDateTime;

public interface OrderRepository {
    void createOrder(Supplier supplier, Product product, LocalDateTime orderDate);
}
