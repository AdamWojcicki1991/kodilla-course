package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(User user, Product product, LocalDateTime orderDate) {
        return !orderDate.toLocalDate().isAfter(LocalDate.now());
    }
}
