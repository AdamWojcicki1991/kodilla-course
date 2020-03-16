package com.kodilla.testing.shape;

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
        int result;
        long temp;
        temp = Double.doubleToLongBits(base);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getShapeName() + "(" + getBase() + "," + getHeight() + ")";
    }
}
