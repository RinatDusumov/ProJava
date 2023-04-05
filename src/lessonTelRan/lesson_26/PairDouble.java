package lessonTelRan.lesson_26;

public class PairDouble {
    private Double x;
    private Double y;

    public PairDouble(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PairDouble{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
