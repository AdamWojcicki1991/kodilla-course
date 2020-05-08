package com.kodilla.good.patterns.food;

import java.time.LocalDate;

public class HealthyShopOrderService implements SupplierOrderService {

    @Override
    public boolean process(OrderRequest orderRequest) {
        for (Product product : orderRequest.getSupplier().getCompanyProducts()) {
            if (product.getProductName().equals(orderRequest.getProduct().getProductName()) &&
                    !orderRequest.getOrderDate().toLocalDate().isAfter(LocalDate.now())) {
                return true;
            }
        }
        return false;
    }
}
