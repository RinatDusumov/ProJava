package udemy.multithreading.synchronizedCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class SynchronizedCollectionsEx2 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            arrayList.add(i);
        }
        List<Integer> synchroList =
                Collections.synchronizedList(arrayList);
        Runnable runnable1 = () -> {
            // работу итератора нужно заключать в synchronized блок
            synchronized (synchroList) {
                Iterator<Integer> itr = synchroList.iterator();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
            }
        };
        Runnable runnable2 = () -> {
            synchroList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(synchroList);
    }
}
