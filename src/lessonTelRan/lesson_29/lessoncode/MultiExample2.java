package lessonTelRan.lesson_29.lessoncode;

public class MultiExample2 {
    public static void main(String[] args) throws InterruptedException {
        Thread tr1 = new Thread(() -> {
            System.out.println("User thread 1 is running");
        });
        Thread tr2 = new Thread(() -> {
            System.out.println("User thread 2 is running");
        });
        tr1.setPriority(Thread.MIN_PRIORITY);
        tr2.setPriority(Thread.MAX_PRIORITY);

        tr1.start();
        tr1.join();

        tr2.start();
    }
}