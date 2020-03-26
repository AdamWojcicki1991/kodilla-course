package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private final Map<String, Boolean> flightMap = new HashMap<>();

    public FlightSearch() {
        flightMap.put("Haneda Airport", true);
        flightMap.put("Los Angeles International Airport", false);
        flightMap.put("Hong Kong International Airport", false);
        flightMap.put("Frankfurt Airport", true);
        flightMap.put("London Heathrow Airport", true);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        if (!flightMap.containsKey(flight.getArrivalAirport()))
            throw new RouteNotFoundException("Airport doesn't exist in Flight Map");
        return flightMap.get(flight.getArrivalAirport());
    }

    public Map<String, Boolean> getFlightMap() {
        return flightMap;
    }
}
