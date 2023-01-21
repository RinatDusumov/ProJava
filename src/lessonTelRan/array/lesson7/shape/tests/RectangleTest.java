package lessonTelRan.array.lesson7.shape.tests;

import lessonTelRan.array.lesson7.shape.entity.Rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        int sideA = 10;
        int sideB = 20;
        String title = "rectangle";
        Rectangle rectangle = new Rectangle(title, sideA, sideB);

        double expectedAreaResult = 200;
        double realAreaResult = rectangle.calculateArea();
        double expectedPerimeterResult = 60;
        double realPerimeterResult = rectangle.calculatePerimeter();

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
