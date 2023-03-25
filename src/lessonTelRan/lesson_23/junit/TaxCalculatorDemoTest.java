package lessonTelRan.lesson_23.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaxCalculatorDemoTest {
    private TaxCalculatorImpl tc = new TaxCalculatorImpl();

    @Test
    public void shouldPayZeroTaxWhenIncomeIsZero() {
        Double income = 0.0;
        Double taxToPay = tc.calculatorTax(income);
        assertEquals(taxToPay, 0);
    }
    @Test
    public void shouldPay25PercentTaxWhenIncomeLess20000() {
        Double income = 10000.0;
        Double taxToPay = tc.calculatorTax(income);
        assertEquals(taxToPay, 2500);
    }
    @Test
    public void shouldPay25PercentTaxWhenIncomeEqual20000() {
        Double income = 20000.0;
        Double taxToPay = tc.calculatorTax(income);
        assertEquals(taxToPay, 5000);
    }
    @Test
    public void shouldPay25And40PercentTaxWhenIncomeMore20000() {
        Double income = 40000.0;
        Double taxToPay = tc.calculatorTax(income);
        assertEquals(taxToPay, 13000);
    }
}