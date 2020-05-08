package com.kodilla.good.patterns.food;

import java.time.LocalDateTime;

public interface InformationService {
    void inform(Supplier supplier, Product product, LocalDateTime orderDate);
}
