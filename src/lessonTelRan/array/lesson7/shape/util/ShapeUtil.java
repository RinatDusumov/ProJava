package lessonTelRan.array.lesson7.shape.util;

import lessonTelRan.array.lesson7.shape.entity.Shape;

import java.util.Random;

public class ShapeUtil {
    public Shape createRandomShape(int range) {
        CreateShape createShape = new CreateShape();
        InputData inputData = new InputData();
        Random rnd = new Random();
        // --------------
        int randomNumber = rnd.nextInt(4);

        if (randomNumber == 0) {
            return createShape.createCircle(inputData.randomValue(range));
        } else if (randomNumber == 1) {
            return createShape.createSquare(inputData.randomValue(range));
        } else if (randomNumber == 2) {
            return createShape.createRectangle(inputData.randomValue(range), inputData.randomValue(range));
        } else {
            return createShape.createTriangle((inputData.randomValue(range)));
        }
    }
    public Shape[] createRandomShapeArray(int arraySize, int range) {
        Shape[] randomShapeArray = new Shape[arraySize];
        for (int i = 0; i < arraySize; i++) {
            randomShapeArray[i] = createRandomShape(range);
        }
        return randomShapeArray;
    }
    public double calculateAllShapesArea(Shape[] shapes) {
        double allShapesArea = 0;
        for (int i = 0; i < shapes.length; i++) {
            allShapesArea = allShapesArea + shapes[i].calculateArea();
        }
        return allShapesArea;
    }
    public double calculateAllShapesPerimeter(Shape[] shapes) {
        double allShapesPerimeter = 0;
        for (int i = 0; i < shapes.length; i++) {
            allShapesPerimeter = allShapesPerimeter + shapes[i].calculatePerimeter();
        }
        return allShapesPerimeter;
    }
}
