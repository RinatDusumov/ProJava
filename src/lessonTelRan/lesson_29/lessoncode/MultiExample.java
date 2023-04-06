package lessonTelRan.lesson_29.lessoncode;

public class MultiExample {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(3);
        Thread tr = new Thread() {
            @Override
            public void run() {
                Thread.currentThread().setName("My name");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getPriority());
            }
        };
        tr.start();
    }
}
