package com.kodilla.good.patterns.flight;

public class FlightRequest {
    private final String departureAirport;
    private final String arrivalAirport;
    private final FlightType flightType;

    public FlightRequest(final String departureAirport, final String arrivalAirport, final FlightType flightType) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightType = flightType;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public FlightType getFlightType() {
        return flightType;
    }
}
