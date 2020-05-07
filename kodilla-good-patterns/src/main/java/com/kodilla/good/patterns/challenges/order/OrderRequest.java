package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDateTime;

public class OrderRequest {
    private final User user;
    private final Product product;
    private final LocalDateTime orderDate;

    public OrderRequest(final User user, final Product product, final LocalDateTime orderDate) {
        this.user = user;
        this.product = product;
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "OrderRequest {" +
                "user=" + user +
                ", product=" + product +
                ", orderDate=" + orderDate +
                '}';
    }
}
