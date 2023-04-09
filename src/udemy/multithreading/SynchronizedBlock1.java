package udemy.multithreading;

public class SynchronizedBlock1 {
    public static void main(String[] args) {
        MyRunnableSynchro myRunnable = new MyRunnableSynchro();
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class CounterS {
    volatile static int count = 0;
}
class MyRunnableSynchro implements Runnable {
    private void doWork2() {
        System.out.println("Ura!");
    }
    private void doWork1() {
        doWork2();
        synchronized (this) {
            CounterS.count++;
            System.out.println(CounterS.count);
        }
    }
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}