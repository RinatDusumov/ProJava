package homeWork._18_01_2023;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numberList = new LinkedList<>();
        int temp;
        int size;

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            numberList.add(new Random().nextInt(100));
            temp = numberList.get(i);
        }
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);

        long start2 = System.currentTimeMillis();
        for (int i : numberList) {}
        long finish2 = System.currentTimeMillis();
        long elapsed2 = finish2 - start2;
        System.out.println("Прошло времени, мс: " + elapsed2);

        long start3 = System.currentTimeMillis();
        for (int i = 0; i < numberList.size(); i++) {}
        long finish3 = System.currentTimeMillis();
        long elapsed3 = finish3 - start3;
        System.out.println("Прошло времени, мс: " + elapsed3);

        long start4 = System.currentTimeMillis();
        for (int i = 0; i < numberList.size(); i++) {
            size = numberList.size();
        }
        long finish4 = System.currentTimeMillis();
        long elapsed4 = finish4 - start4;
        System.out.println("Прошло времени, мс: " + elapsed4);

        long start5 = System.currentTimeMillis();
        for (int i = numberList.size() - 1; i > 0; i--) {
            size = numberList.size();
        }
        long finish5 = System.currentTimeMillis();
        long elapsed5 = finish5 - start5;
        System.out.println("Прошло времени, мс: " + elapsed5);

        long start6 = System.currentTimeMillis();
        Iterator<Integer> itr = numberList.iterator();
        while (itr.hasNext()) {
            size = itr.next();
        }
        long finish6 = System.currentTimeMillis();
        long elapsed6 = finish6 - start6;
        System.out.println("Прошло времени, мс: " + elapsed6);

        long start7 = System.currentTimeMillis();
        ListIterator<Integer> iter = numberList.listIterator();
        while (iter.hasPrevious()) {
            size = iter.previous();
        }
        long finish7 = System.currentTimeMillis();
        long elapsed7 = finish7 - start7;
        System.out.println("Прошло времени, мс: " + elapsed7);
    }
}
