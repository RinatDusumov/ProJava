package udemy.multithreading.concurrentCollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
        ConcurrentHashMap имплементирует интерфейс ConcurrentMap,
    который в свою очередь происходит от интерфейса Map.
        В ConcurrentHashMap любое количество потоков может
    читать элементы не блокируя его.
        В ConcurrentHashMap, благодаря его сегментированию (разделению),
    при изменении какого-либо элемента блокируется только bucket,
    в котором он находится (определённый сегмент с элементом).

        В ConcurrentHashMap ни key, ни value не могут быть null.
 */
class ConcurrentHashMapEx {
    public static void main(String[] args) throws InterruptedException {
        //HashMap<Integer, String> map = new HashMap<>();
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Zaur");
        map.put(2, "Oleg");
        map.put(3, "Sergey");
        map.put(4, "Ivan");
        map.put(5, "Igor");

        Runnable runnable1 = () -> {
            Iterator<Integer> itr = map.keySet().iterator();
            while (itr.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = itr.next();
                System.out.println(i + " : " + map.get(i));
            }
        };
        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Marina");
        };
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(map);
    }
}