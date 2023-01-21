package lessonTelRan.array.lesson9.setCollections;

import java.util.SortedSet;
import java.util.TreeSet;

public class DifferentTypesSetCollections {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        sortedSet.add("A");
        sortedSet.add("B");
        sortedSet.add("C");
        sortedSet.add("A");

        System.out.println(sortedSet);
        // повторное добавление не произошло, потому что такой элемент уже есть

        sortedSet.add("D");
        sortedSet.add("E");
        sortedSet.add("F");
        sortedSet.add("G");
        sortedSet.add("H");
        System.out.println(sortedSet.first()); // первый элемент
        System.out.println(sortedSet.last()); // крайний элемент

        for (String str : sortedSet) {
            System.out.print(str + ", ");
        }
        String checkContains = "D";

        System.out.println("Contains " + checkContains + " " + sortedSet.contains(checkContains));
        System.out.println("First value " + sortedSet.first());
        System.out.println("Last value " + sortedSet.last());

        sortedSet.remove("D");
        System.out.println("After removing element " + sortedSet);

        for (String value : sortedSet) {
            System.out.print(value + ", ");
        }
    }
}
