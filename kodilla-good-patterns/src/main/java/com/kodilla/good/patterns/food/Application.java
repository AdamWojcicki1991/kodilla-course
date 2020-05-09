package com.kodilla.good.patterns.food;

public class Application {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new SupplierInformationService(),
                orderRequest.getSupplier().getSupplierOrderService(),
                new SupplierOrderRepository());

        Order order = orderProcessor.order(orderRequest);
        System.out.println(order);
    }
}
