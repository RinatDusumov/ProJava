package lessonTelRan.lesson_29.multiThread.multi.multi2;

public class SecondThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MySecondThread tr = new MySecondThread();
            tr.start();
        }
    }
}
