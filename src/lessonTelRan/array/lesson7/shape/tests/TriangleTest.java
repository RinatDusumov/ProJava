package lessonTelRan.array.lesson7.shape.tests;

import lessonTelRan.array.lesson7.shape.entity.Triangle;

public class TriangleTest {
    public static void main(String[] args) {
        int side = 10;
        String title = "triangle";
        Triangle triangle = new Triangle(title, side);

        double expectedAreaResult = 100 * Math.sqrt(3) / 4;
        double realAreaResult = triangle.calculateArea();
        double expectedPerimeterResult = 30;
        double realPerimeterResult = triangle.calculatePerimeter();

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
