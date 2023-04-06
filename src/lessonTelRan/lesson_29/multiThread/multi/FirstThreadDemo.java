package lessonTelRan.lesson_29.multiThread.multi;

public class FirstThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyFirstThread tr = new MyFirstThread();
            tr.start();
        }
    }
}
