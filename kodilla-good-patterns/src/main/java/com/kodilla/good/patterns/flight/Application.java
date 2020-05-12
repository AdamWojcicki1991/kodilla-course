package com.kodilla.good.patterns.flight;

public class Application {

    public static void main(String[] args) {
        FlightRequestRetriever flightRequestRetriever = new FlightRequestRetriever();
        FlightRequest flightRequest = flightRequestRetriever.retrieve();

        FlightProcessor flightProcessor = new FlightProcessor(new FlightScanner());

        try {
            String scannedFlights = flightProcessor.process(flightRequest);
            System.out.println(scannedFlights);
        } catch (FlightNotFoundException flightNotFoundException) {
            System.out.println(flightNotFoundException.getMessage());
        } finally {
            System.out.println("\nFlight search ended");
        }
    }
}
