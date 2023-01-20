package udemy.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Elena");
        arrayList.add("Adam");
        arrayList.add("Eva");
        arrayList.add("Ivan");

        Iterator<String> iter = arrayList.iterator();
        /* iterator - повторитель
           с помощью объекта iterator можно пробежаться по элементам list
         */
        while (iter.hasNext()) { // если имеет следующий элемент
            iter.next(); // получить след. элемент
            iter.remove();
        }

    }
}
