package lessonTelRan.lesson16.stream;

import java.util.stream.IntStream;

public class Example {
    public static void main(String[] args) {
        // Пример без потока
        int[] arr = {50, 60, 70, 80, 90, 100, 110, 120};
        int count = 0;
        for (int x : arr) {
            if (x >= 90) {
                continue;
            }
            x += 10;
            count++;
            if (count > 3) {
                break;
            }
            System.out.println(x + ", ");
        }
        System.out.println();

        // Пример с потоком
        IntStream.of(50, 60, 70, 80, 90, 100, 110, 120)
                .filter(x -> x < 90)
                .map(x -> x + 10)
                .limit(3)
                .forEach(System.out::print);
    }
}
