package lessonTelRan.lesson16.stream.streamExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {
        List<String> coll_str = Arrays.asList("10","20","100","10","15","50","25");
        List<Integer> coll_int = Arrays.asList(1,2,3,4,5,6);

        /**
         * findFirst() - вернет элемент, соответствующий условию, который стоит первым
         */
        // find first
        System.out.println("GetFirst result: " + coll_str.stream().findFirst().orElse("0"));

        /**
         * collect() - соберет результаты обработки в коллекции и не только
         */
        // collect
        System.out.println("Collect.toSet() result: " + coll_str.stream().collect(Collectors.toSet()));

        /**
         * count() - посчитает и выведет, сколько элементов, соответствующих условию
         */
        // count
        System.out.println("Count result: " + coll_str.stream().count());

        /**
         * anyMatch() - вернёт true, когда хоть один элемент соответствует условиям
         */
        // anyMatch
//        System.out.println(coll_str.stream().anyMatch("10"::equals));
        System.out.println("anyMatch() result: " + coll_str.stream().anyMatch(x -> x.equals("10")));

        /**
         * allMatch() - вернёт true, когда все элементы соответствуют условиям
         */
        // allMatch
        System.out.println("allMatch() result: " + coll_str.stream().allMatch(x -> x.equals("10")));

        /**
         * min() - найдет самый маленький элемент, используя переданный сравнитель
         */
        // min() for str
        System.out.println("Result of min for col_str: " + coll_str.stream()
                .min((s, anotherString) -> s.compareTo(anotherString)));
        // min for int
        System.out.println("Result of min for col_int: " + coll_int.stream()
                .min((x,y) -> x.compareTo(y)));

        /**
         * forEach() - применит функцию ко всем элементам, но порядок выполнения гарантировать не может
         */
        // foreach
        System.out.println("Result of foreach(): ");
        coll_str.stream().forEach(p -> System.out.println(p + " "));
        System.out.println();

        // toArray
        String[] qwe = coll_str.stream().toArray(String[]::new);
        System.out.println("Result of toArray(): " + Arrays.toString(qwe));

        /**
         * reduce() - преобразует все элементы в один объект
         */
        System.out.println("Result of reduce: " + coll_str.stream()
                .reduce((c1, c2) -> c1 + " " + c2));
        // reduce with int
        System.out.println("Result of reduce with int: " + coll_int.stream()
                .reduce((a,b) -> (a + b)));
    }
}
