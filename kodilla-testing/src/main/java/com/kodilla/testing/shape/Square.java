package com.kodilla.testing.shape;

public class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return side * side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        return side == square.side;
    }

    @Override
    public int hashCode() {
        return side;
    }
}