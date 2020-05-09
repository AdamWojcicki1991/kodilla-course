package com.kodilla.good.patterns.flight;

public class FlightNotFoundException extends Exception {

    public FlightNotFoundException(final String message) {
        super(message);
    }
}
