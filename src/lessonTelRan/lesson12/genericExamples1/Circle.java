package lessonTelRan.lesson12.genericExamples1;

// Класс, реализующий интерфейс Figure
public class Circle<T extends Number> implements Figure<T> {
    private T radius;
    private T x, y;

    // Конструктор
    public Circle (T x, T y, T radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Вернуть площадь
    public double Area() {
        return Math.PI * Math.pow(radius.doubleValue(), 2);
    }
}
