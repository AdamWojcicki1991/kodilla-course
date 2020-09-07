package com.kodilla.testing2.shape;

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
        int i = 0;

        for (Shape shape : shapes) {
            i++;
            if (i != shapes.size()) {
                showFigures += shape + ", ";
            } else {
                showFigures += shape;
            }
        }
        return showFigures;
    }
}
