package udemy.arrayList;

import java.util.ArrayList;

public class ArrayListMethods {
    public static void main(String[] args) {
        // для сравнения объектов переопределяется метод equals
        ArrayList<String> arrayList = new ArrayList<>();

        // для добавления нового элемента
        arrayList.add(0,"Alisa");
        arrayList.add("Barsik");

        // для добавления ArrayList
        ArrayList<String> al = new ArrayList<>();
        arrayList.addAll(al); // все значения списка al добавляются в конец
        arrayList.addAll(1, al); // добавления начинается с определённого индекса

        // для получения элемента
        String str = arrayList.get(0);
        System.out.println("str - " + str);

        // для изменения элемента по индексу
        arrayList.set(0, "Sofia");
        System.out.println(arrayList);

        // для удаления
        arrayList.remove(0); // по индексу
        arrayList.remove("Barsik"); // по элементу

        // для полного очищения
        arrayList.clear();

        //возвращает индекс элемента
        arrayList.indexOf("Barsik"); // если нет возвращает -1
        arrayList.lastIndexOf(""); // вернёт индекс крайнего совпадения

        // возвращает размер
        arrayList.size();

        // проверка пустой arraylist или нет
        System.out.println(arrayList.isEmpty());

        // проверка содержит ли arraylist определённый элемент
        arrayList.contains("Alisa"); // возвращает true или false

        // toString для преобразования в строку
    }
}
