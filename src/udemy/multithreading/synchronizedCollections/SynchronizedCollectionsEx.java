package udemy.multithreading.synchronizedCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
        Synchronized collections получаются из традиционных коллекций
    благодаря их обёртыванию.
    (class) Collections.synchronizedXYZ(коллекция), вместо XYZ указывается коллекция,
    которая будет обёрткой.
 */
class SynchronizedCollectionsEx {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> source = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            source.add(i);
        }
        //ArrayList<Integer> target = new ArrayList<>();
        List<Integer> synchroList =
                Collections.synchronizedList(new ArrayList<>());

        Runnable runnable = () -> {synchroList.addAll(source);};

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(synchroList);
    }
}