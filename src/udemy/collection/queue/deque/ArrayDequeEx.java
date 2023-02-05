package udemy.collection.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Deque - double ended queue (двунаправленная очередь).
    В такой очереди элементы могут использоваться с обоих концов.
    Здесь работают оба правила - FIFO и LIFO.

    Интерфейс Deque реализуется классами LinkedList и ArrayDeque.
 */
public class ArrayDequeEx {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        /* addFirst(), addLast(), offerFirst(), offerLast()
           removeFirst(), removeLast(), pollFirst(), pollLast()
           getFirst(), getLast(), peekFirst(), peekLast()
         */
        // LinkedList также использует двойные методы
        deque.addFirst(3);
        deque.addFirst(5);
        deque.addLast(7);
        deque.offerFirst(1);
        deque.offerLast(8);
        System.out.println(deque);

    }
}
