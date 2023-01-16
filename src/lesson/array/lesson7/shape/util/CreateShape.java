package lesson.array.lesson7.shape.util;

import lesson.array.lesson7.shape.entity.Circle;
import lesson.array.lesson7.shape.entity.Rectangle;
import lesson.array.lesson7.shape.entity.Square;
import lesson.array.lesson7.shape.entity.Triangle;

public class CreateShape {
    public Circle createCircle(double radius) {
        return new Circle("circle", radius);
    }
    public Square createSquare(double side) {
        return new Square("square", side);
    }
    public Rectangle createRectangle(double sideA, double sideB) {
        return new Rectangle("rectangle", sideA, sideB);
    }
    public Triangle createTriangle(double side) {
        return new Triangle("triangle", side);
    }
}
