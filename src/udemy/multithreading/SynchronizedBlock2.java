package udemy.multithreading;

public class SynchronizedBlock2 {
    volatile static int couter = 0;
    public static void increment() {
        synchronized (SynchronizedBlock2.class) {
            couter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R2());
        Thread thread2 = new Thread(new R2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
class R2 implements Runnable {
    @Override
    public void run() {

    }
}