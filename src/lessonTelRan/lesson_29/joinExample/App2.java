package lessonTelRan.lesson_29.joinExample;

import java.util.concurrent.TimeUnit;

public class App2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        };
        Thread tr = new Thread(task);
        tr.start();
        tr.join();
        System.out.println("Finished");
    }
}
// JVisualVM