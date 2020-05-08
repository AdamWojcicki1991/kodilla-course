package com.kodilla.good.patterns.food;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        Supplier supplier = new Supplier("ExtraFoodShop", "4799  Wines Lane, Houston", new ExtraFoodShopOrderService());
        Product product = new Product("Cheese", 26);
        LocalDateTime orderDate = LocalDateTime.of(2020, 3, 1, 12, 0);
        return new OrderRequest(supplier, product, orderDate);
    }
}
