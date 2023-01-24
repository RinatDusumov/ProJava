package udemy.collection.hashSet;

import java.util.HashSet;
import java.util.Set;

/* Set (множество) - коллекция, хранящая только уникальные элементы.
Методы данной коллекции очень быстры. Допускает значение null.

HashSet не запоминает порядок добавления элементов.
В основе HashSet лежит HashMap. У элементов данного HashMap:
ключи - это элементы HashSet, значения - это константа-заглушка.
 */
public class HashSetEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Zaur"); // внутри вызывает метод put, который принадлежит HashMap
        set.add("Oleg");
        set.add("Marina");

        set.remove("Zaur");

        //System.out.println(set);
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("Marina"));
    }
}
