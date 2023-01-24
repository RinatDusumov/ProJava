package udemy.collection.arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {
    public static void main(String[] args) {
        // первый способ создания arraylist
        ArrayList<String> arrayList1 = new ArrayList<String>();
        arrayList1.add("Ivan");
        arrayList1.add("Mariya");
        System.out.println(arrayList1);

        // второй способ создания arraylist
        ArrayList<String> arrayList2 = new ArrayList<>();

        // третий способ создания arraylist, когда известно кол-во элементов
        ArrayList<String> arrayList3 = new ArrayList<>(30);

        // четвёртый способ создания arraylist
        List<String> arrayList4 = new ArrayList<>();

        // пятый способ создания arraylist
        ArrayList<String> arrayList5 = new ArrayList<>(arrayList1);
        /* arrayList5 не ссылается на ту же ссылку что arrayList1,
           дублируя те же самые значения
         */

        // пятый способ создания arraylist
        ArrayList arrayList6 = new ArrayList();
        /* благодаря такому способу в arrayList6 можно добавлять данные
           разных типов, так как по умолчанию ArrayList храенит данные
           типа Object.
           Так делать не рекомедуется и нужно использовать джейнерики
         */
    }
}
