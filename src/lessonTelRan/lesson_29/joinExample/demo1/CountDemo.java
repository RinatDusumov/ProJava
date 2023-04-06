package lessonTelRan.lesson_29.joinExample.demo1;

public class CountDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new Thread(new CounterRunnable(counter));
        Thread thread2 = new Thread(new CounterRunnable(counter));

        thread1.start();
        thread2.start();
        try {
             thread1.join();
             thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cout = " + counter.getCount());
    }
}