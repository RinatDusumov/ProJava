package udemy.multithreading.concurrentCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
        CopyOnWriteArrayList имплементирует интерфейс List.

        CopyOnWriteArrayList следует использовать тогда, когда нужно
    добиться потоко-безопасности, у вас небольшое количество операций
    по изменению элементов и большое количество по их чтению.
 */
public class CopyOnWriteArraysListExample {
    public static void main(String[] args) throws InterruptedException {
        //CopyOnWriteArraySet
        //ArrayList<String> list = new ArrayList<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Zaur");
        list.add("Oleg");
        list.add("Sergey");
        list.add("Ivan");
        System.out.println(list);

        Runnable runnable1 = () -> {
            Iterator<String> itr = list.iterator();
            while (itr.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(itr.next());
            }
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4);
            list.add("Elena");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);
    }
}