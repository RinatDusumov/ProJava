package udemy.collection.hashSet;

import java.util.HashSet;

public class HashSetEx2 {
    public static void main(String[] args) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(7);
        hashSet1.add(3);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(3);
        hashSet2.add(2);
        hashSet2.add(8);

        HashSet<Integer> union = new HashSet<>(hashSet1);
        // union - объединение
        union.addAll(hashSet2);
        System.out.println(union); // объединяет объекты, не добавляя дубликаты

        HashSet<Integer> intersect = new HashSet<>(hashSet1);
        // intersect - пересечение
        intersect.retainAll(hashSet2); // оставляет пересекающиеся элементы

        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        // subtract - разность
        subtract.retainAll(hashSet2); // удалить из hashset1 все элементы hashset2
        System.out.println(subtract);
    }
}
