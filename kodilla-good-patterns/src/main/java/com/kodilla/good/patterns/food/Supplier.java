package com.kodilla.good.patterns.food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supplier {
    private final String companyName;
    private final String companyAddress;
    private final SupplierOrderService supplierOrderService;
    private final List<Product> companyProducts;

    public Supplier(final String companyName, final String companyAddress, final SupplierOrderService supplierOrderService) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.supplierOrderService = supplierOrderService;
        this.companyProducts = createCompanyProductList();
    }

    public SupplierOrderService getSupplierOrderService() {
        return supplierOrderService;
    }

    public List<Product> getCompanyProducts() {
        return companyProducts;
    }

    private List<Product> createCompanyProductList() {
        final List<Product> products = new ArrayList<>();
        products.add(new Product("Eggs", new Random().nextInt(50)));
        products.add(new Product("Apple", new Random().nextInt(50)));
        products.add(new Product("Bread", new Random().nextInt(50)));
        products.add(new Product("Milk", new Random().nextInt(50)));
        products.add(new Product("Cheese", new Random().nextInt(50)));
        return products;
    }

    @Override
    public String toString() {
        return companyName + " " + companyAddress;
    }
}
