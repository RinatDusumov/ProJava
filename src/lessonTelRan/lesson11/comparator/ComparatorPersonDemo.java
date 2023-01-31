package lessonTelRan.lesson11.comparator;

import java.util.SortedSet;
import java.util.TreeSet;

public class ComparatorPersonDemo {
    public static void main(String[] args) {
        SortedSet<PersonNew> set = new TreeSet<>();

        set.add(new PersonNew("Petr", "Petrov", 35));
        set.add(new PersonNew("Victor", "Vladimirov", 43));
        set.add(new PersonNew("Sergey", "Sidorov", 45));

        set.forEach(System.out::println);
    }
}
