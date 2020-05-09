package com.kodilla.good.patterns.flight;

import static com.kodilla.good.patterns.flight.FlightType.WITH_TRANSFER;

public class FlightRequestRetriever {

    public FlightRequest retrieve() {
        String departureAirport = "Gdansk Lech Walensa Airport";
        String arriveAirport = "Wroclaw Airport";
        return new FlightRequest(departureAirport, arriveAirport, WITH_TRANSFER);
    }
}
