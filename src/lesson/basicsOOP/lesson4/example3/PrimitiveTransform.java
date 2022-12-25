package lesson.basicsOOP.lesson4.example3;

public class PrimitiveTransform {
    public static void main(String[] args) {
        int x = 10;
        double y = 12.5;

        Integer xRef = x;
        Double yRef = y;

        System.out.println(xRef);
        System.out.println(yRef);

        int resUnpack = xRef.intValue();
    }
}
