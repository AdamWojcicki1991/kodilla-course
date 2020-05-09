package com.kodilla.good.patterns.flight;

import java.util.List;

public interface FlightService {
    List<Flight> findFlight(FlightRequest flightRequest);
}
