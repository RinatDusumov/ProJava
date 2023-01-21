package lessonTelRan.array.lesson7;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int parametr1 = 5;
        int parametr2 = 10;

        int expectedResult = 15;
        int realResult = calculator.sum(parametr1, parametr2);

        if (expectedResult == realResult) {
            System.out.println("Test passed OK");
        } else {
            System.out.println("Test passed FAIL");
            System.out.println("Expected result - " + expectedResult +
                    " but real result is - " + realResult);
        }
    }
}
