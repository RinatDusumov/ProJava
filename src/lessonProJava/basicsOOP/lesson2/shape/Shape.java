package lessonProJava.basicsOOP.lesson2.shape;

abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }
    public abstract double calculateArea();
}
