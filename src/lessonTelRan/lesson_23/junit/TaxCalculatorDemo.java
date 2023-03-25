package lessonTelRan.lesson_23.junit;

public class TaxCalculatorDemo {
    public static void main(String[] args) {
        TaxCalculatorImpl tc = new TaxCalculatorImpl();

        System.out.println("Income = " + 4000 + " tax will " + tc.calculatorTax(4000.0));
        System.out.println("Income = " + 10000 + " tax will " + tc.calculatorTax(10000.0));
        System.out.println("Income = " + 20000 + " tax will " + tc.calculatorTax(20000.0));
        System.out.println("Income = " + 30000 + " tax will " + tc.calculatorTax(30000.0));

    }
}
