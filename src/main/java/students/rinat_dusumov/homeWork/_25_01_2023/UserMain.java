package main.java.students.rinat_dusumov.homeWork._25_01_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

public class UserMain {
    static Random random = new Random();
    public static void main(String[] args) {
        /**
         * Task 1
         * Напишите метод, который получает на вход Map и возвращает Map, где ключи и значения поменяны местами.
         * Так как значения могут совпадать, то тип значения в Map будет уже не K, а Collection: Map> */
        HashMap<Integer, String> map = new HashMap<>();
        map.put(33, "Polina");
        map.put(21, "Alina");
        map.put(20, "Sofia");
        HashMap<? extends String, ? extends Integer> revMap = (HashMap<String, Integer>) collectionMap(map);
        System.out.println("Task 1: " + revMap);

        /**
         * Task 2
         * Напишите метод, который получает на вход массив элементов типа К (используйте Generic)
         * и возвращает Map, где K — значение из массива, а Integer — количество вхождений в массив.
         * То есть сигнатура метода выглядит так: Map arrayToMap(TypeK[] array);
         */
        String[] array = {"dfs", "sdve", "wefwe"};
        Map<String, ? extends Object> arrayMap = arrayInMap(array);
        System.out.println("Task 2: " + arrayMap);

        /**
         * Task 3
         * Создайте класс HeavyBox, содержащий несколько параметров (длина, высота, ширина, вес).
         *     Создать TreeSet содержащий HeavyBox.
         *     HeavyBox должен реализовать интерфейс Comparable.
         *     Распечатать содержимое с помощью for each.
         */
        TreeSet treeSet = new TreeSet<>();
        treeSet.add(new HeavyBox(random.nextInt(30), random.nextInt(30),
                random.nextInt(30), random.nextInt(30)));
        treeSet.add(new HeavyBox(random.nextInt(30), random.nextInt(30),
                random.nextInt(30), random.nextInt(30)));
        treeSet.add(new HeavyBox(random.nextInt(30), random.nextInt(30),
                random.nextInt(30), random.nextInt(30)));
        System.out.println("Task 3:");
        for (Object set : treeSet) {
            System.out.println(set);
        }
    }
    public static <K, V> Map<V, K> collectionMap (Map<K, V> map) {
        HashMap<V, K> rev = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            rev.put(entry.getValue(), entry.getKey());
        }
        return rev;
    }
    public static <K, V> Map<K, V> arrayInMap(K[] array) {
        HashMap<K, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
            map.put(array[i], count);
        }
        return (Map<K, V>) map;
    }
}