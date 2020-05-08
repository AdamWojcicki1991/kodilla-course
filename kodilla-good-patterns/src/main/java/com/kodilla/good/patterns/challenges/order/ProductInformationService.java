package com.kodilla.good.patterns.challenges.order;

public class ProductInformationService implements InformationService {

    @Override
    public void inform(User user, Product product) {
        System.out.println(user + " you ordered a " + product);
    }
}
