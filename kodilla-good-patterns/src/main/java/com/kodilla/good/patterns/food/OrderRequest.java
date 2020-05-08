package com.kodilla.good.patterns.food;

import java.time.LocalDateTime;

public class OrderRequest {
    private final Supplier supplier;
    private final Product product;
    private final LocalDateTime orderDate;

    public OrderRequest(final Supplier supplier, final Product product, final LocalDateTime orderDate) {
        this.supplier = supplier;
        this.product = product;
        this.orderDate = orderDate;
    }

    public Supplier getSupplier() {
        return supplier;
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
                "user=" + supplier +
                ", product=" + product +
                ", orderDate=" + orderDate +
                '}';
    }
}
