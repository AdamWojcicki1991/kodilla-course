package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double baseDimension;
    private double heightDimension;

    public Triangle(int baseDimension, int heightDimension) {
        this.baseDimension = baseDimension;
        this.heightDimension = heightDimension;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public double getField() {
        return (baseDimension * heightDimension) / 2;
    }
}