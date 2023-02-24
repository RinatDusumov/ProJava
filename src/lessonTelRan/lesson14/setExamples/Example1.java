package lessonTelRan.lesson14.setExamples;

import java.util.TreeSet;

public class Example1 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        set.add("A");
        set.add("B");
        set.add("A");
        set.add("C");

        System.out.println(set);

        String d = "D";
        System.out.println("Contains " + d + " in TreeSet: " + set.contains(d));
        System.out.println("First value: " + set.first());
        System.out.println("Last value: " + set.last());

        /** removing values */
        // удаление значений
        set.add(d);
        set.remove("B");
        System.out.println(set);
    }
}
