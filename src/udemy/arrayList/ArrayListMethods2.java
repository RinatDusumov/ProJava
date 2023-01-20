package udemy.arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethods2 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");

        StringBuilder[] array = {sb1, sb2, sb3};
        // для преобразования array в list
        List<StringBuilder> list = Arrays.asList(array);
        System.out.println(list); // не забывать клонировать данные

        /* для удаления в arraylist всех элементов arraylist2
           указанного в параметрах
           removeAll(Collection <?> c)
        */

        /* для сохранения в arraylist тех элементов arraylist2
           указанного в параметрах
           retainAll(Collection <?> c)
           остальные удаляются
         */

        /* проверяет содержит ли arraylist все элементы arraylist2
           указанного в параметрах
           containsAll(Collection <?> c)
         */
        System.out.println("--------");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Elena");
        arrayList.add("Ivan");
        arrayList.add("Alex");
        arrayList.add("Marina");

        List<String> myList = arrayList.subList(0,3); // крайний индекс не учитывается
        // в список myList записаны элементы c 0 по 2 индексы, некий отрезок от arraylist
        myList.add("Fedor");
        System.out.println(myList);
        System.out.println(arrayList);
        // изменения в sublist отражаются и в arraylist

        // toArray используется для преобразования list в массив с типом Object
        Object[] arrayObject = arrayList.toArray();

        // c такой конструкцией уже можно преобразовывать в более уместный тип данных
        String[] arrayStr = arrayList.toArray(new String[0]);

        // создание list и добавление элементов без использования метода add
        List<Integer> list1 = List.of(3, 8, 13);
        System.out.println(list1); // нельзя изменять и они не содержат null

        // для копирования arraylist
        List<String> list2 = List.copyOf(arrayList);
        System.out.println(list2); // также не модифицируется и не содержат null
    }
}
