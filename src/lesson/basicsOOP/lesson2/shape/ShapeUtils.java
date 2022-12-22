package lesson.basicsOOP.lesson2.shape;

public class ShapeUtils {
    public double sumAreas(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            sum = shape.calculateArea() + sum;
        }
        return sum;
    }
}
