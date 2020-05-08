package com.kodilla.good.patterns.challenges.order;

public class Product {
    private final String productName;

    public Product(final String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return productName;
    }
}
