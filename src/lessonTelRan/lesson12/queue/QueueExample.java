package lessonTelRan.lesson12.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // первый зашел, первый вышел
        int time = 100;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = time; i >= 0; i--) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
