package com.kodilla.good.patterns.flight;

import static com.kodilla.good.patterns.flight.FlightType.FLIGHT_WITH_TRANSFER;

public class FlightRequestRetriever {

    public FlightRequest retrieve() {
        String departureAirport = "Gdansk Lech Walensa Airport";
        String arriveAirport = "Wroclaw Airport";
        return new FlightRequest(departureAirport, arriveAirport, FLIGHT_WITH_TRANSFER);
    }
}
