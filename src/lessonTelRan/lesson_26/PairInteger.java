package lessonTelRan.lesson_26;

public class PairInteger {
    private Integer x;
    private Integer y;

    public PairInteger(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PairInteger{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}