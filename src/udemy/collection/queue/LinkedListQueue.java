package udemy.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
    Queue (очередь) - это коллекция, хранящая последовательность
    элементов. Добавляется элемент в конец очереди, используется
    из начала очереди - правило FIFO (первый вошёл, первый вышел).

    Класс LinkedList имплементирует не только интерфейс List,
    но и интерфейс Deque.

    Добавляем в конец, работаем с первым элементом.
    Ecли нужны элементы из середины, тогда лучше использовать другую коллекцию
 */
public class LinkedListQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        // add() - добавляет в конец очереди (последовательность сохраняется)
        queue.add("Zaur");
        queue.add("Oleg");
        queue.add("Ivan");
        queue.add("Mariya");
        queue.add("Alex");
        System.out.println(queue);

        /* offer() - при случае ограничения размера очереди,
            элемент выходящий за рамки не будет добавлен.
            (при использовании add() в этом же случае выйдет ошибка)
         */

        System.out.println(queue.remove()); // возвращает удалённый элемент
        // poll() - удаляет элементы. Когда очередь уже пуста вернёт null.

        // Метод element() показывает первый элемент в очереди
        System.out.println(queue.element());

        /* peek() - показывает первый элемент, но если очередь пуста
            вернёт null.
         */

        queue.remove("Ivan");
        System.out.println(queue);
    }
}
