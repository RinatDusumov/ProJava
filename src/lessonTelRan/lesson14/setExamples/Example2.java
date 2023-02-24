package lessonTelRan.lesson14.setExamples;

import java.util.TreeSet;

public class Example2 {
    /** Итерация по SortedSet */
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("A");

        for (String value : set) {
            System.out.println(value + " ");
        }
    }
}
