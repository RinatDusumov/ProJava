package udemy.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadEx2 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1_000, 1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 5; i > 0; i--) {
//            System.out.println(i);
//            Thread.sleep(1_000);
//        }
//        System.out.println("O'key");
        Thread thread1 = new Thread(new MyRunnableImpl());
        ThreadEx2 thread2 = new ThreadEx2();
        System.out.println(thread1.getState()); // получить состояние потока

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join(1500);
        // ожидание окончания работы или ожидание до окончания выделенного времени

        System.out.println("End");
    }
}
class MyRunnableImpl implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}