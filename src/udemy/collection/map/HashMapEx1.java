package udemy.collection.map;

import java.util.HashMap;
import java.util.Map;
/*
    В основе HashMap лежит массив. Элементами данного массива
    являются структуры LinkedList. Данные структуры LinkedList
    и заполняются элементами, которые добавляются в HashMap.

    При создании HashMap можно задать 2 параметра, которые очень
    влияют на производительность:
        - Initial capacity - начальный размер массива
        - Load factor - коэффициент того, насколько массив должен
        быть заполнен, после чего его размер будет увеличен вдвое.

    Элементами HashMap являются пары ключ/значение.
    HashMap не запоминает порядок добавления элементов.
    Его методы работают очень быстро.

    Ключи элементов должны быть уникальными. Ключ может быть null.
    Значения элементов могут повторяться. Значения могут быть null.

    Ключ всегда должен быть неизменяемым.
 */

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        // put - метод добавления элементов в map
        map1.put(1000, "Zaur Tregulov");
        map1.put(3453, "Mariya Sidorowa");
        map1.put(6574, "Olga Nelson");

        // putIfAbsent - добавить элемент, если такового нет
        map1.putIfAbsent(1000, "Oleg Ivanov");
        System.out.println(map1);

        // get - вывести значение по ключу
        System.out.println(map1.get(1000));

        // remove - удаление по ключу
        map1.remove(3453);
        System.out.println();

        // containsValue - проверяет есть ли определённкое значение
        System.out.println(map1.containsValue("Ivan Ivanov"));

        // containsKey - проверяет есть ли определённый ключ
        System.out.println(map1.containsKey(500));

        // keySet - возвращает множество всех ключей, которые есть в HashMap
        System.out.println(map1.keySet());

        // values - возвращает множество всех значений
        System.out.println(map1.values());

        // entrySet - возвращает множество Entry(внутренний интерфейс для Map)

        for (Map.Entry<Integer, String> ent : map1.entrySet()) {
            System.out.println(ent.getKey() + " " + ent.getValue());
        }

        Map<Integer, String> map2 = new HashMap<>(16, 0.75f);
    }
}
