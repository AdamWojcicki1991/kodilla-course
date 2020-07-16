package com.kodilla.hibernate.manytomany.facade.api;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
