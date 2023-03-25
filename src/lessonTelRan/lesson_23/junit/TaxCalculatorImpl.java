package lessonTelRan.lesson_23.junit;

import java.math.BigDecimal;

public class TaxCalculatorImpl implements TaxCalculator {
    @Override
    public Double calculatorTax(Double income) {
        Double tax = 0.0;
        Double range_20000 = 20000.0;
        Double taxForRange20000 = 5000.0;

        if (income > range_20000) {
            tax = taxForRange20000 + (income - range_20000) * 0.4;
        } else {
            tax = income * 0.25;
        }


        return null;
    }
}
