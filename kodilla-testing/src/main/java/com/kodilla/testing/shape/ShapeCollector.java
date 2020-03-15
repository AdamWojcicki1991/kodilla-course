package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public int getShapesQuantity() {
        return shapes.size();
    }

    public String showFigures() {

        String showFigures = "";

        for (Shape shape : shapes) {

            showFigures += shape.getShapeName() + " has a field size equals: " + shape.getField();
        }
        return showFigures;
    }
}