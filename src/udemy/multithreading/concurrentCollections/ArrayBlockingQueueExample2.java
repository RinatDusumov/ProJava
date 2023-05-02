package udemy.multithreading.concurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;

/**
    put() - добавляет элементы в конец очереди; ждёт, если очередь полна
    take() - забирает и удаляет первый элемент из очереди; ждёт добавления, если очередь пуста
 */
public class ArrayBlockingQueueExample2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        // Producer
        new Thread(() -> {
           int i = 0;
           while (true) {
               try {
                   queue.put(++i);
                   System.out.println("Producer добавил: " + i + " "
                           + queue);
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();

        // Consumer
        new Thread(() -> {
            while (true) {
                try {
                    Integer j = queue.take();
                    System.out.println("Consumer забрал: " + j + " "
                            + queue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
