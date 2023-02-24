package udemy.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream (поток данных) - это последовательность элементов, поддерживающих
 * последовательные и параллельные операции над ними.
 *
 *
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela");
        list.add("ok");
        list.add("poka");

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
//        System.out.println(list);

        /** 6 9 2 4 */
        // list.stream().map(element -> element.length());
        List<Integer> list2 = list.stream().map(element -> element.length())
                .collect(Collectors.toList());
        System.out.println(list);

        int[] array = {5, 6, 23, 65,35};
        array = Arrays.stream(array).map(element
        -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        //System.out.println(Arrays.toString(array));

        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela");
        set.add("ok");
        set.add("poka");

        Set<Integer> set2 = set.stream().map(e->e.length())
                .collect(Collectors.toSet());
        List<Integer> list3 = set.stream().map(e->e.length()).collect(Collectors.toList());
        System.out.println(list3);
        //System.out.println(set2);
    }
}
