package com.kodilla.good.patterns.food;

public class GlutenFreeShopOrderService implements SupplierOrderService {

    @Override
    public boolean process(OrderRequest orderRequest) {
        for (Product product : orderRequest.getSupplier().getCompanyProducts()) {
            if (product.getProductName().equals(orderRequest.getProduct().getProductName()) &&
                    product.getQuantity() >= orderRequest.getProduct().getQuantity()) {
                return true;
            }
        }
        return false;
    }
}
