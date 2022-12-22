package lessonProJava.lesson2.shape;

class Square extends Shape {
    private int sideA;
    public Square(String name, int sideA) {
        super(name);
        this.sideA = sideA;
    }
    @Override
    public double calculateArea() {
        return sideA * sideA;
    }
}
