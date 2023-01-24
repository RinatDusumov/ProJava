package udemy.collection.hashSet.LinkedHashSet;

/* LinkedHashSet является наследником HashSet.
Хранит информацию о порядке добавления элементов.
Производительность методов немного ниже, чем у методов HashSet.
В основе LinkedHashSet лежит HashMap. У элементов данного HashMap:
ключи - это элементы LinkedHashSet, значения - это константа-заглушка.
 */

import java.util.LinkedHashSet;

public class LinkedHashSetEx {
    public static void main(String[] args) {
        LinkedHashSet<Integer> ihs = new LinkedHashSet<>();
        ihs.add(5);
        ihs.add(3);
        ihs.add(1);
        System.out.println(ihs); // выводит элементы в порядке добавления

        ihs.remove(8);
        System.out.println(ihs);
        System.out.println(ihs.contains(8));
    }
}
