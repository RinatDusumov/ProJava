package udemy.collection.hashSet.treeSet;

/* TreeSet хранит элементы в отсортированном по возрастанию порядке.
В основе TreeSet лежит TreeMap. У элементов данного TreeMap:
ключи - это элементы TreeSet, значения - это константа-заглушка.
 */

import java.util.Set;
import java.util.TreeSet;

public class TreeSetEx1 {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(2);
        treeSet.add(10);
        System.out.println(treeSet);

        treeSet.remove(2);
        System.out.println(treeSet);
        System.out.println(treeSet.contains(10));
    }
}
