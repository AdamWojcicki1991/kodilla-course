package com.kodilla.good.patterns.flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FlightScanner implements FlightService {
    private final List<Flight> flights;

    public FlightScanner() {
        this.flights = createFlights();
    }

    @Override
    public List<Flight> findFlight(final FlightRequest flightRequest) {
        if (flights == null) return Collections.emptyList();
        switch (flightRequest.getFlightType()) {
            case FROM_AIRPORT:
                return flights.stream()
                        .filter(flight -> flight.getDepartureAirport().equals(flightRequest.getDepartureAirport()))
                        .collect(Collectors.toList());
            case TO_AIRPORT:
                return flights.stream()
                        .filter(flight -> flight.getArrivalAirport().equals(flightRequest.getArrivalAirport()))
                        .collect(Collectors.toList());
            case DIRECT_FLIGHT_FROM_TO:
                return flights.stream()
                        .filter(flight -> flight.getDepartureAirport().equals(flightRequest.getDepartureAirport()) && flight.getArrivalAirport().equals(flightRequest.getArrivalAirport()))
                        .collect(Collectors.toList());
            case WITH_TRANSFER:
                List<Flight> flightsFrom = flights.stream()
                        .filter(flight -> flight.getDepartureAirport().equals(flightRequest.getDepartureAirport()))
                        .collect(Collectors.toList());
                List<Flight> flightsTo = flights.stream()
                        .filter(flight -> flight.getArrivalAirport().equals(flightRequest.getArrivalAirport()))
                        .collect(Collectors.toList());
                List<Flight> flightsTransfers = new ArrayList<>();
                for (Flight flightFrom : flightsFrom) {
                    flightsTo.stream()
                            .filter(flight -> flight.getDepartureAirport().equals(flightFrom.getArrivalAirport()))
                            .map(flight -> new Flight(flightFrom.getDepartureAirport(), flight.getDepartureAirport(), flight.getArrivalAirport()))
                            .forEach(flightsTransfers::add);
                }
                return flightsTransfers;
            default:
                return Collections.emptyList();
        }
    }

    public List<Flight> getFlights() {
        return flights;
    }

    private List<Flight> createFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Gdansk Lech Walensa Airport", "Wroclaw Airport"));
        flights.add(new Flight("Krakow Airport", "Wroclaw Airport"));
        flights.add(new Flight("Krakow Airport", "Eindhoven Airport"));
        flights.add(new Flight("Oslo Airport", "Wroclaw Airport"));
        flights.add(new Flight("Stockholm Airport", "Wroclaw Airport"));
        flights.add(new Flight("Gdansk Lech Walensa Airport", "Krakow Airport"));
        flights.add(new Flight("Gdansk Lech Walensa Airport", "Oslo Airport"));
        flights.add(new Flight("Gdansk Lech Walensa Airport", "Eindhoven Airport"));
        flights.add(new Flight("Gdansk Lech Walensa Airport", "Stockholm Airport"));
        return flights;
    }
}
