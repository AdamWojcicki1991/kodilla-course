package com.kodilla.good.patterns.food;

public class Order {
    private final Supplier supplier;
    private final Product product;
    private final boolean isProductOrdered;

    public Order(final Supplier supplier, final Product product, final boolean isProductOrdered) {
        this.supplier = supplier;
        this.product = product;
        this.isProductOrdered = isProductOrdered;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isProductOrdered() {
        return isProductOrdered;
    }

    @Override
    public String toString() {
        return "Supplier: " + supplier +
                ", Product: " + product +
                ", Amount: " + product.getQuantity() +
                ", isOrdered: " + isProductOrdered;
    }
}
