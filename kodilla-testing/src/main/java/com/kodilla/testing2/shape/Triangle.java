package com.kodilla.testing2.shape;

import java.util.Objects;

public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public double getField() {
        return (base * height) / 2;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.base, base) != 0) return false;
        return Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height);
    }

    @Override
    public String toString() {
        return getShapeName() + "(" + base + "," + height + ")";
    }
}
