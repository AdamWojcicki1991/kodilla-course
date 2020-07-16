package com.kodilla.hibernate.manytomany.facade.api;

public class CompanyNotFoundException extends Exception {
    public CompanyNotFoundException(String message) {
        super(message);
    }
}
