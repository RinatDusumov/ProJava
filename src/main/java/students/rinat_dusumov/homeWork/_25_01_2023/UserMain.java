package main.java.students.rinat_dusumov.homeWork._25_01_2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

public class UserMain {
    static Random random = new Random();
    public static void main(String[] args) {
        // task 1
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> revMap = (HashMap<String, Integer>) collectionMap(map);

        // task 2
        String[] array = {"dfs", "sdve", "wefwe"};
        Map<String, Object> arrayMap = arrayInMap(array);

        // task 3
        TreeSet treeSet = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            treeSet.add(new HeavyBox(random.nextInt(50), random.nextInt(50),
                    random.nextInt(50), random.nextInt(50)));
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