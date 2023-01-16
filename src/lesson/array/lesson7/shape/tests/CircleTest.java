package lesson.array.lesson7.shape.tests;

import lesson.array.lesson7.shape.entity.Circle;

public class CircleTest {
    public static void main(String[] args) {
        int radius = 10;
        String title = "circle";
        Circle circle = new Circle(title, radius);

        double expectedAreaResult = Math.PI * 100;
        double realAreaResult = circle.calculateArea();
        double expectedPerimeterResult = 20 * Math.PI;
        double realPerimeterResult = circle.calculatePerimeter();

        printTestResult("calculate area", expectedAreaResult, realAreaResult);
        printTestResult("calculate perimeter", expectedPerimeterResult, realPerimeterResult);
    }
    public static void printTestResult(String message, double expectedResult, double realResult) {
        if (expectedResult == realResult) {
            System.out.println("Test " + message + " passed OK!");
        } else {
            System.out.println("Test " + message + " passed FAIL!");
            System.out.println("Expected result - " + expectedResult +
                    " but real result is - " + realResult);
        }
    }
}
