package udemy.collection.map;

import java.util.TreeMap;

/*
    Элементами TreeMap являются пары ключ/значение.
    В TreeMap элементы хранятся в отсортированном по возрастанию
    порядке (сортировка по ключу).

    В основе TreeMap лежит красно-чёрное дерево. Это позволяет
    методам работать быстро, но не быстрее, чем методы HashMap.

    Уникальные ключи

    Основная цель использования TreeMap это нахождение отрезков
 */
public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Double, String> treeMap = new TreeMap<>();

        treeMap.put(5.8, "Ivan");
        treeMap.put(6.0, "Albert");
        treeMap.put(5.5, "Piter");
        System.out.println(treeMap);

        // descendingMap - вывести ключи по убыванию
        System.out.println(treeMap.descendingMap());

        // tailMap - для вывода ключей, что больше 6.0
        System.out.println(treeMap.tailMap(6.0));
        // headMap - для вывода ключей, что меньше 6.0
        System.out.println(treeMap.headMap(6.0));

        // lastEntry - для вывода крайнего элемента
        System.out.println(treeMap.lastEntry());
        // firstEntry - для вывода первого элемента
        System.out.println(treeMap.firstEntry());
    }
}
