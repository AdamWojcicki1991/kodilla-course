package com.kodilla.good.patterns.flight;

import java.util.Objects;

public class Flight {
    private final String departureAirport;
    private final String arrivalAirport;
    private final String transferAirport;

    public Flight(final String departureAirport, final String arrivalAirport) {
        this(departureAirport, "", arrivalAirport);
    }

    public Flight(final String departureAirport, final String transferAirport, final String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.transferAirport = transferAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        return Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(transferAirport, flight.transferAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, transferAirport, arrivalAirport);
    }

    @Override
    public String toString() {
        if (transferAirport.equals("")) {
            return "Flight " + departureAirport + " -> " + arrivalAirport;
        } else {
            return "Flight " + departureAirport + " -> " + transferAirport + " -> " + arrivalAirport;
        }
    }
}
