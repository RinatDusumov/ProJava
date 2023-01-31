package lessonTelRan.lesson11.comparable;

import java.util.SortedSet;
import java.util.TreeSet;

/*
    Data Transfer Object (DTO) — один из шаблонов проектирования,
    используется для передачи данных между подсистемами приложения.
 */
public class ComparePersonDemo {
    public static void main(String[] args) {
        SortedSet<PersonNew> set = new TreeSet<>();

        set.add(new PersonNew("James", "Smit", 27));
        set.add(new PersonNew("Rinat", "Potter", 32));
        set.add(new PersonNew("Mattew", "Black", 25));

        set.forEach(System.out::println);
    }
}
