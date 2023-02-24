package lessonTelRan.lesson17.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** Надо понимать в какой последовательности и какие действия
  * нужно произвести. */
class Stream2 {
    public static void main(String[] args) {
        List<Integer> number = List.of(10,-1,222,-8,3,47,5,61,-7,47,8,-9,20,30,50);

        List<Integer> list = number.stream()
                .filter(n -> n > 0)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);

        /** Первоначальные данные не меняются */
        System.out.println(number);

        int minResult = number.stream()
                .filter(x -> x > 0)
                .min((x, y) -> Integer.compare(x, y))
                .orElse(0);
        System.out.println("min = " + minResult);

        int sum = number.stream()
                .filter(x -> x > 0)
                .reduce((x, y) -> x + y)
                .orElse(0);
        System.out.println("Sum of all elements = " + sum);

        int sumNegativs = number.stream()
                .filter(x -> x < 0)
                .reduce((x, y) -> x + y)
                .orElse(0);
        System.out.println("Sum of all negativs elements = " + sumNegativs);
    }
}