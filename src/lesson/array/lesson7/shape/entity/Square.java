package lesson.array.lesson7.shape.entity;

public class Square extends Shape {
    private double sideA;

    public Square (String title, double sideA) {
        super(title);
        this.sideA = sideA;
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideA=" + sideA +
                '}';
    }

    @Override
    public double calculateArea() {
        return sideA * sideA;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideA;
    }
}
