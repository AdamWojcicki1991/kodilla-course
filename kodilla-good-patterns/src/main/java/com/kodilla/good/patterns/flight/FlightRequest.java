package com.kodilla.good.patterns.flight;

public class FlightRequest {
    private final String departureAirport;
    private final String arrivalAirport;

    public FlightRequest(final String departureAirport, final String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
