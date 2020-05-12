package com.kodilla.good.patterns.flight;

import java.util.List;

public interface FlightService {
    List<Flight> findFlightFrom(FlightRequest flightRequest);

    List<Flight> findFlightTo(FlightRequest flightRequest);

    List<Flight> findFlightDirect(FlightRequest flightRequest);

    List<Flight> findFlightWithChanges(FlightRequest flightRequest);
}
