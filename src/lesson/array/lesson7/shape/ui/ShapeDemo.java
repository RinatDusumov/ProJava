package lesson.array.lesson7.shape.ui;

import lesson.array.lesson7.shape.entity.Shape;
import lesson.array.lesson7.shape.util.ShapeUtil;

import java.util.Arrays;

public class ShapeDemo {
    public static void main(String[] args) {
        ShapeUtil shapeUtil = new ShapeUtil();

        Shape ourRandomShape = shapeUtil.createRandomShape(20);
        printShapeInfo("Our shape : ", ourRandomShape.toString(),
                " Shape area is " + ourRandomShape.calculateArea() +
                " and shape perimeter is " + ourRandomShape.calculatePerimeter());
        // -----------------

        Shape[] randomShapesArray = shapeUtil.createRandomShapeArray(10, 20);
        // System.out.println(Arrays.toString(randomShapesArray));
        double allShapesArea = shapeUtil.calculateAllShapesArea(randomShapesArray);
        double allShapesPerimeter = shapeUtil.calculateAllShapesPerimeter(randomShapesArray);

        printShapeInfo(Arrays.toString(randomShapesArray), " All shapes area is " + allShapesArea,
                " all shapes perimeter is " + allShapesArea);
    }
    public static void printShapeInfo(String messageShape, String messageInfo, String messageData) {
        System.out.println(messageShape);
        System.out.println(messageInfo);
        System.out.println(messageData);
    }
}