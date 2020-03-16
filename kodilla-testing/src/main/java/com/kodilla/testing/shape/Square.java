package com.kodilla.testing.shape;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return side * side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(side);
        return (int) (temp ^ (temp >>> 32));
    }

    @Override
    public String toString() {
        return getShapeName() + "(" + getSide() + "," + getSide() + ")";
    }
}
