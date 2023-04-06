package lessonTelRan.lesson_28.multithreading;

public class UseRunnable {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                Thread.sleep(5_000);
                System.out.println("Hello world");
                System.out.println("Finish thread");
            } catch (InterruptedException err) {
                throw new RuntimeException(err);
            }
        };
        System.out.println("Start program");
        System.out.println("Pause 5 sec");

        Thread thread = new Thread(r);
        thread.start();

        System.out.println("Finish program");
    }
}