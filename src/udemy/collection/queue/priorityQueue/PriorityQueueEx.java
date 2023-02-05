package udemy.collection.queue.priorityQueue;

import java.util.PriorityQueue;

/*
    PriorityQueue - это специальный вид очереди, в котором используется
    натуральная сортировка или та, которую мы описываем с помощью
    Comparable или Comparator. Таким образом используется тот элемент
    из очереди, приоритет которого выше.
    (Наивысшем приоритетом обладает первый элемент в очереди)
 */
public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(4);
        priorityQueue.add(1);
        priorityQueue.add(7);
        priorityQueue.add(10);
        priorityQueue.add(8);
        // натуральная последовательность - 1 4 7 8 10

        System.out.println(priorityQueue.peek());
    }
}
