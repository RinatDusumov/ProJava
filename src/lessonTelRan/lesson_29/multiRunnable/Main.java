package lessonTelRan.lesson_29.multiRunnable;

public class Main {
    public static void main(String[] args) {
        Thread tr = new Thread(new MyRunnable());
        tr.start();
    }
}
