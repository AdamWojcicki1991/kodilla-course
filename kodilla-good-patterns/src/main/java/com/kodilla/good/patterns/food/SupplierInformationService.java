package com.kodilla.good.patterns.food;

import java.time.LocalDateTime;

public class SupplierInformationService implements InformationService {

    @Override
    public void inform(Supplier supplier, Product product, LocalDateTime orderDate) {
        System.out.println(supplier + " Food2Door company ordered " + product.getQuantity() + " " + product + " form your shop.");
    }
}
