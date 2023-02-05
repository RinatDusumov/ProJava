package udemy.generics;

import java.util.ArrayList;
import java.util.List;
/*
    Две основные причины существования джейнериков (<> - даймонд) :

    Type Safe (безопасность)
        - позволяет создавать коллекции определённых типов
    & Reusable Code
        - джейнериксы <> позволяют не создавать дубликатный код
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

//        list.add("OK");
//        list.add(5);
//        list.add(new StringBuilder("vdsv"));

        list.add("privet");
        list.add("poka");
        list.add("ok");
        //list.add(new StringBuilder());
        for (Object o : list) {
            System.out.println(o + " dlina " + ((String) o).length());
        }

    }
}
