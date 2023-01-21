package lessonTelRan.array.lesson7.shape.tests;

import lessonTelRan.array.lesson7.shape.entity.Square;

public class SquareTest {
    public static void main(String[] args) {
        int sideA = 10;
        String title = "square";
        Square square = new Square(title, sideA);

        double expectedAreaResult = 100;
        double realAreaResult = square.calculateArea();
        double expectedPerimeterResult = 40;
        double realPerimeterResult = square.calculatePerimeter();

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
