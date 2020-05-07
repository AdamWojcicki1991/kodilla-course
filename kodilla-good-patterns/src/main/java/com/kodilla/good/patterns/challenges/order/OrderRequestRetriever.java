package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("John", "Carmack");
        Product product = new Product("Apple Macbook Air 13");
        LocalDateTime orderDate = LocalDateTime.of(2020, 3, 1, 12, 0);
        return new OrderRequest(user, product, orderDate);
    }
}
