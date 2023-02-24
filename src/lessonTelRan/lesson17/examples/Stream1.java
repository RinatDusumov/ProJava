package lessonTelRan.lesson17.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Stream1 {
    public static void main(String[] args) {
        List<Integer> number = List.of(1,2,3,4,5,6,7,8,9);

        List<Integer> evenList = getEvenNumbers(number);
        System.out.println(evenList);

        System.out.println("------- with stream -------");
        System.out.println(getEvenNumbersStream(number));
    }
    public static List<Integer> getEvenNumbers (List<Integer> collection) {
        List<Integer> listForReturn = new ArrayList<>();
        for (Integer i : collection) {
            if (i % 2 == 0) {
                listForReturn.add(i);
            }
        }
        return listForReturn;
    }
    public static List<Integer> getEvenNumbersStream (List<Integer> collection) {
        return collection.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
    }
}