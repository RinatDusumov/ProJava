package lessonProJava.lesson2.shape;

public class ShapeUtilsDemo {
    public static void main(String[] args) {
        ShapeUtils utils = new ShapeUtils();

        Circle[] circles = {
                new Circle("A", 2),
                new Circle("B", 5),
                new Circle("C", 10),
        };

        Square[] squares = {
                new Square("A", 10),
                new Square("B", 20),
                new Square("C", 30),
        };

        double circleAreas = utils.sumAreas(circles);
        double squareAreas = utils.sumAreas(squares);

        System.out.println("Circle areas = " + circleAreas);
        System.out.println("Square areas = " + squareAreas);

        Square[] squares1 = {
                new Square("A", 10),
                new Square("B", 20),
                new Square("C", 30),
        };

        double circleAreas1 = utils.sumAreas(circles);
        double squareAreas1 = utils.sumAreas(squares);

        System.out.println("");

    }
}
