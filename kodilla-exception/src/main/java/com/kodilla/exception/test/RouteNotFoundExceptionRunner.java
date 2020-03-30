package com.kodilla.exception.test;

public class RouteNotFoundExceptionRunner {
    public static void main(String[] args) {
        Flight flight = new Flight("Haneda Airport", "Dubai International Airport");
        FlightSearch flightSearch = new FlightSearch();
        boolean flightAvailable = false;

        try {
            flightAvailable = flightSearch.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (flightAvailable)
                System.out.println("\nWe have available flight to " + flight.getArrivalAirport());
            else {
                System.out.println("\nWe haven't available flight to " + flight.getArrivalAirport());
            }
        }
    }
}
