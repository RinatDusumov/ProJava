package lessonTelRan.lesson11.generik;

import java.math.BigDecimal;

public class PairDemo {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>();
        pair.setLeft("A");
        pair.setRight(234);

        Pair<BigDecimal, Double> newPair = new Pair<>();
        newPair.setLeft(BigDecimal.ONE);
        newPair.setRight(10.5);

        System.out.println(pair);
        System.out.println(newPair);
    }
}
