package com.kodilla.good.patterns.flight;

public class FlightRequestRetriever {

    public FlightRequest retrieve() {
        String departureAirport = "Gdansk Lech Walensa Airport";
        String arriveAirport = "Wroclaw Airport";
        return new FlightRequest(departureAirport, arriveAirport);
    }
}
