package lessonTelRan.lesson_30;

public class App1 {
    public static void main(String[] args) {
        // currentThread() - показывает текущий поток в котором сейчас находимся
        var threadName = Thread.currentThread().getName();
        System.out.println("Thread that is executing: " + threadName);
    }
}
