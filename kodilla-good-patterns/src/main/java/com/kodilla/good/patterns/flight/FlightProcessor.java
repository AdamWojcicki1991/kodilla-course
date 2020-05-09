package com.kodilla.good.patterns.flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightProcessor {
    private final FlightService flightService;

    public FlightProcessor(final FlightService flightService) {
        this.flightService = flightService;
    }

    public String process(final FlightRequest flightRequest) throws FlightNotFoundException {
        List<Flight> scannedFlights = flightService.findFlight(flightRequest);
        if (scannedFlights.isEmpty())
            throw new FlightNotFoundException("Airport doesn't exist in our flights");
        return scannedFlights.stream()
                .map(Flight::toString)
                .collect(Collectors.joining("\n"));
    }
}
