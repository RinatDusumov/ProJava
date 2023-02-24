package lessonTelRan.lesson16.stream.streamPractice;

import java.util.Arrays;

/**
 * посчитать общее количество слов (дополнительно,
 * посчитать только не повторяющиеся слова)
 */
public class Example4 {
    public static void main(String[] args) {
        String[][] array = new String[][] {
                {"Hello", "world"}, {"Hello", "Java"}, {"Hello", "student"}, {"Welcome", "to", "Tel-Ran"}
        };
        // решение
        long count = Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .count();
        System.out.println(count);

        long count2 = Arrays.stream(array)
                .flatMap(x -> Arrays.stream(x))
                .distinct()
                .count();
        System.out.println(count2);
    }
}
