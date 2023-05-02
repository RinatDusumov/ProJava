package udemy.multithreading.concurrentCollections;

import java.util.concurrent.ArrayBlockingQueue;

/**
        ArrayBlockingQueue - потоко безопасная очередь с ограниченным
    размером (capacity restricted).

        Обычно один или несколько потоков добавляют элементы в конец очереди,
    а другой или другие потоки забирают элементы из начала очереди.
 */

public class ArrayBlockingQueueExample {
    public static void main(String[] args) { // FIFO
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.offer(5); // не будет добавлен
        System.out.println(queue);
    }
}
