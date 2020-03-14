package com.kodilla.testing.shape;

public class Circle implements Shape {
    private int radiusDimension;

    public Circle(int radiusDimension) {
        this.radiusDimension = radiusDimension;
    }

    public String getShapeName() {
        return "Circle";
    }

    public double getField() {
        double pi = 3.14;
        return pi * (radiusDimension * radiusDimension);
    }
}
