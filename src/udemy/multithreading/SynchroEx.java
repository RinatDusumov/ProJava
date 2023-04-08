package udemy.multithreading;

public class SynchroEx {
    public static void main(String[] args) {
        MyRunnableImpl11 runnable = new MyRunnableImpl11();

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Counter{
    volatile static int count = 0;
}
class MyRunnableImpl11 implements Runnable {
    synchronized public void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
