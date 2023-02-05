package lessonTelRan.lesson12.genericExamples1;

/*
    Класс, который реализует интерфейс Figure и ограничивается
    использованием числовых типов
 */
public class Rectangle<T extends Number> implements Figure<T> {
    private T x1, y1, x2, y2; // координаты прямоугольника

    // Конструктор
    public Rectangle(T x1, T y1, T x2, T y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Вернуть площадь прямоугольника
    public double Area() {
        return Math.abs(x1.doubleValue() - x2.doubleValue())
                * Math.abs(y1.doubleValue() - y2.doubleValue());
    }
}
