package lessonTelRan.array.lesson9.setCollections;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetCollectionsExample {
    public static void main(String[] args) {
        HashSet<String> stringHashSet = new HashSet<>();
        // быстро сравнивает по HashCode

        stringHashSet.add("January");
        stringHashSet.add("February");
        stringHashSet.add("March");
        stringHashSet.add("April");
        stringHashSet.add("May");

        System.out.println(stringHashSet);

        HashSet<ArrayList> ourSetExample = new HashSet<>();

        ArrayList<Integer> intArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Student> studentArrayList = new ArrayList<>();

        intArrayList.add(1);
        intArrayList.add(2);
        intArrayList.add(3);
        intArrayList.add(4);

        stringArrayList.add("January");
        stringArrayList.add("February");
        stringArrayList.add("March");
        stringArrayList.add("April");

        ourSetExample.add(intArrayList);
        ourSetExample.add(stringArrayList);

        System.out.println(ourSetExample.size());
        System.out.println(ourSetExample);
        // коллекции внутри коллекции должны быть одного типа данных

        studentArrayList.add(new Student(1, "Petr"));
        studentArrayList.add(new Student(2, "Ira"));
        studentArrayList.add(new Student(3, "Aksel"));

        ourSetExample.add(studentArrayList);
        System.out.println(ourSetExample);

    }
}
