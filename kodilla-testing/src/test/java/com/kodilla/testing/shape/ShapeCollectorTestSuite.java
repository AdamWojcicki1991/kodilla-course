package com.kodilla.testing.shape;

import org.junit.*;

import java.util.List;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle(5);
        //When
        shapeCollector.addFigure(circle);
        //Then
        Assert.assertEquals(1, shapeCollector.getShapesQuantity());
    }

    @Test
    public void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape square = new Square(5);
        shapeCollector.addFigure(square);
        //When
        shapeCollector.removeFigure(square);
        //Then
        Assert.assertEquals(0, shapeCollector.getShapesQuantity());
    }

    @Test
    public void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Square(5));
        shapeCollector.addFigure(new Circle(5));
        shapeCollector.addFigure(new Triangle(5, 5));
        //When
        Shape shape1 = shapeCollector.getFigure(0);
        Shape shape2 = shapeCollector.getFigure(1);
        Shape shape3 = shapeCollector.getFigure(2);
        //Then
        Assert.assertEquals("Square", shape1.getShapeName());
        Assert.assertEquals(25.0, shape1.getField(), 0.00001);
        Assert.assertEquals("Circle", shape2.getShapeName());
        Assert.assertEquals(78.5, shape2.getField(), 0.00001);
        Assert.assertEquals("Triangle", shape3.getShapeName());
        Assert.assertEquals(12.5, shape3.getField(), 0.00001);
    }

    @Test
    public void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Square(5));
        shapeCollector.addFigure(new Circle(5));
        shapeCollector.addFigure(new Triangle(5, 5));
        //When
        List<Shape> shapes = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(shapes, shapeCollector.showFigures());
    }
}