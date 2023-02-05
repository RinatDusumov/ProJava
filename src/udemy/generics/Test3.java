package udemy.generics;

import java.util.ArrayList;
import java.util.List;
// Wildcards - супер карта
/*
    <? extends X> - класс X или любой его сабкласс (наследники)
    <? super Y> - класс Y или любой его суперкласс
 */
public class Test3 {
    public static void main(String[] args) {
        List<?> list = new ArrayList<String>();
        //list.add(""); нельзя изменять объект

        // использовать bounded wildcard - ограничение
        List<? extends Number> list30 = new ArrayList<Integer>();
        List<? super Number> list131 = new ArrayList<Number>();

        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        showListIngo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("world");
        list2.add("please");
        showListIngo(list2);

        ArrayList<Double> ald = new ArrayList<>();
        ald.add(3.14);
        ald.add(3.25);
        ald.add(4.21);
        System.out.println(summ(ald));
    }
    static void showListIngo (List<?> list) {
        System.out.println(list);
    }
    public static double summ (ArrayList<? extends Number> al) {
        double sum = 0;
        for (Number n : al) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
