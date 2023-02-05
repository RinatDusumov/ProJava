package lessonTelRan.lesson12.genericExamples1;

public class GenericDemoWithInterface {
    public static void main(String[] args) {
        // Тест класса Rectangle<Integer>
        Rectangle<Integer> rInt = new Rectangle<Integer>(1, 2, 3, 5);
        double areaRect = rInt.Area();
        System.out.println("areaRect = " + areaRect);

        // Тест класса Rectangle<Double>
        Rectangle<Double> rDouble = new Rectangle<Double>(1.5, 2.3, 0.8, 0.7);
        areaRect = rDouble.Area();
        System.out.println("areaRect = " + areaRect);

        // Тест класса Circle<Float>
        Circle<Float> cFloat = new Circle<Float>(1.5f, 2.2f, 3.0f);
        double areaCircle = cFloat.Area();
        System.out.println("areaCircle = " + areaCircle);

        /*
        Так делать нельзя!!!
        Circle<Boolean> cBoolean = new Circle<Boolean>(true, false, false); - ошибка, тип Boolean не числовой
         */

    }
}
