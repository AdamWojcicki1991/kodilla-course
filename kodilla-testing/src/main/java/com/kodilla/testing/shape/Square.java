package com.kodilla.testing.shape;

public class Square implements Shape {
    private int sideOfSquareDimension;

    public Square(int sideOfSquareDimension) {
        this.sideOfSquareDimension = sideOfSquareDimension;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return sideOfSquareDimension * sideOfSquareDimension;
    }
}