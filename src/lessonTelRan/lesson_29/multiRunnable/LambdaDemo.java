package lessonTelRan.lesson_29.multiRunnable;

public class LambdaDemo {
    public static void main(String[] args) {
        Thread tr = new Thread(() -> System.out.println("Thread is running"));
        tr.start();
    }
}
