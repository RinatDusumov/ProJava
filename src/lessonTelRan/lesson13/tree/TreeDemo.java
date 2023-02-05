package lessonTelRan.lesson13.tree;

import java.util.TreeMap;

public class TreeDemo {
    public static void main(String[] args) {
        TreeMap<Student, Integer> map = new TreeMap<>();

        map.put(new Student(33, "Alex"), 33);
        map.put(new Student(19, "Tomas"), 19);
        map.put(new Student(23, "Ivan"),23);

        System.out.println(map.firstKey());
    }
}