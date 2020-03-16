package com.kodilla.testing.shape;

import org.junit.*;

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
        Assert.assertEquals(circle, shapeCollector.getFigure(0));
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
        Square square = new Square(5);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(5, 5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        //When
        Shape shape1 = shapeCollector.getFigure(0);
        Shape shape2 = shapeCollector.getFigure(1);
        Shape shape3 = shapeCollector.getFigure(2);
        //Then
        Assert.assertEquals(square, shape1);
        Assert.assertEquals(circle, shape2);
        Assert.assertEquals(triangle, shape3);
    }

    @Test
    public void testShowFigures() {
        //Given
        Square square = new Square(5);
        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(5, 5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(triangle);
        //When
        String shapes = shapeCollector.showFigures();
        //Then
        Assert.assertEquals(square.toString() + ", " + circle.toString() + ", " + triangle.toString(), shapes);
    }
}
