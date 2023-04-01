package algorithms._2023_02_17_Reference;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            list.add(new Random().nextInt(22)); // от 0 до 22
        }
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            // таким образом изменять элементы коллекции
            if (list.get(i) % 2 == 0) {
                System.out.println(list.get(i));
            }
        }
        for (Integer a : list) {
            System.out.println(a);
        }

        list.stream() // ctrl + q
                .filter(el -> el % 2 == 0)
                .map(el -> el * 10)
                .peek(el -> {
                    if (el % 6 == 0) {
                        System.out.println(el);
                    }
                })
                .forEach(System.out::println);
        // с использованием промежуточных и терминальных методов

        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        //stream.

        //Arrays.stream(array)
    }
}
