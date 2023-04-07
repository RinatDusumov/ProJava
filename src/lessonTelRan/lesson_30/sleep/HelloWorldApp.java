package lessonTelRan.lesson_30.sleep;

import java.util.concurrent.TimeUnit;

public class HelloWorldApp {
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                int secToWait = 1000 * 60;
                Thread.currentThread().sleep(secToWait);
                //TimeUnit.SECONDS.sleep(60); - альтернатива
                System.out.println("Waked up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread tr = new Thread(task);
        tr.start();
    }
}
