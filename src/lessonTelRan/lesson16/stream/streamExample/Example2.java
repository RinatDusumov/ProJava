package lessonTelRan.lesson16.stream.streamExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Конвеерные операции
 */
public class Example2 {
    public static void main(String[] args) {
        List<String> c = Arrays.asList("10", "20", "1", "10", "15", "50", "25", "20", "25");
        System.out.println("Original: " + c);

        /**
         * filter() - отработает как фильтр, вернет значения, которые подходят под заданное условие.
         * count() - посчитает и выведет, сколько элементов, соответствующих условию
         */
        // filter & count
        long result = c.stream().filter(p -> p.equals("10")).count();
        System.out.println("Result of filtering and counting: " + result);

        /**
         * sorted() - отсортирует элементы в естественном порядке;
         * можно использовать Comparator
         */
        // sorted
        List<String> result2 = c.stream().sorted().collect(Collectors.toList());
        System.out.println("Result of sorting: " + result2);

        /**
         * limit() - лимитирует вывод по тому, количеству, которое вы укажете
         */
        // sorted & limit
        List<String> result3 = c.stream().sorted().limit(3).collect(Collectors.toList());
        System.out.println("Result of sorting and limit(3): " + result3);

        /**
         * skip() - пропустит указанное вами количество элементов
         */
        // sorted & skip
        List<String> result4 = c.stream().sorted().skip(3).collect(Collectors.toList());
        System.out.println("Result of sorting and skip(3): " + result4);

        /**
         * distinct() - найдет и уберет элементы, которые повторяются; вернет элементы без повторов
         */
        // distinct
        List<String> result5 = c.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println("Result of distinct: " + result5);

        /**
         * peek() - выполнить действие над каждым элементом элементов, вернет стрим с исходными элементами
         */
        // actions via peek()
        System.out.println("Result of peek() method: ");
        c.stream()
                .peek(e -> System.out.print(e + " hello; "))
                .collect(Collectors.toList());
        System.out.println();

        /**
         * map() - выполнит действия над каждым элементом; вернет элементы с результатами функций
         */
        // map example1
        System.out.println("Result of map() method: ");
        c.stream().map(x -> x + " times").forEach(q -> System.out.println(q + " "));
        System.out.println();

        // map example2
        int[] q = new int[] {1,2,3,4,5};
        int[] qq = Arrays.stream(q).map(x -> x + 10).toArray();
        System.out.println("Result of map example2: " + Arrays.toString(qq));

        /**
         * mapToInt() - Сработает как map, только вернет числовой stream
         */
        // mapToInt
        int[] result6 = c.stream().mapToInt(x -> Integer.parseInt(x)).toArray();
        System.out.println("Result of mapToInt() method: " + Arrays.toString(result6));

        /**
         * flatmap() - сработает как map, но преобразует один элемент в ноль, один или множество других
         */
        // flatmap (как бы распаковка коллекции или работа с элементами элементов коллекции)
        ArrayList<List<Integer>> l1 = new ArrayList<>();

        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(4);
        two.add(5);
        two.add(6);

        l1.add(one);
        l1.add(two);

        System.out.print("Result of flatmap method: ");
        l1.stream()
                .flatMap(x -> x.stream())
                .map(x -> x * 2)
                .forEach(x -> System.out.println(x + " "));
        System.out.println();

        // flatmap example2
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1,list2,list3);
        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        System.out.println("Result of example2 for flatmap method: " + listOfAllIntegers);
    }
}
