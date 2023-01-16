package lesson.array.lesson7.shape.tests;

import lesson.array.lesson7.shape.entity.*;
import lesson.array.lesson7.shape.util.ShapeUtil;

public class ShapeUtilTest {
    public static void main(String[] args) {
        ShapeUtil shapeUtil = new ShapeUtil();
        Shape[] shapeArrayTest = new Shape[4];

        shapeArrayTest[0] = new Circle("circle", 10);
        shapeArrayTest[1] = new Square("square", 10);
        shapeArrayTest[2] = new Rectangle("rectangle", 10, 20);
        shapeArrayTest[3] = new Triangle("triangle", 10);

        double expectedAreaResult = Math.PI * 100 + 100 + 200 + 100 * Math.sqrt(3) / 4;
        double realAreaResult = shapeUtil.calculateAllShapesArea(shapeArrayTest);
        double expectePerimeterResult = 20 * Math.PI + 40 + 60 + 30;
        double realPerimeterResult = shapeUtil.calculateAllShapesPerimeter(shapeArrayTest);

        printTestResult("calculate area", expectedAreaResult, realAreaResult);
        printTestResult("calculate perimeter", expectePerimeterResult, realPerimeterResult);
    }
    public static void printTestResult (String message, double expectedResult, double realResult) {
        if (expectedResult == realResult) {
            System.out.println("Test " + message + " passed OK!");
        } else {
            System.out.println("Test " + message + " passed FAIL!");
            System.out.println("Expected result - " + expectedResult +
                    " but real result is - " + realResult);
        }
    }
}
