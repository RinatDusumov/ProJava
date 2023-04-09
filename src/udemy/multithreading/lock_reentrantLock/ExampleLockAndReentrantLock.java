package udemy.multithreading.lock_reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock - интерфейс, который имплементируется классом ReentrantLock.
 * Также как ключевое слово synchronized, Lock нужен для
 * достижения синхронизации между потоками.
 */
public class ExampleLockAndReentrantLock {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.skypeCall();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.whatsAppCall();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class Call {
    private Lock lock = new ReentrantLock();
    void mobileCall() {
        lock.lock(); // для закрытия замка монитора объекта lock
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // для открытия замка.
            /** unlock() пишется всегда в блоке finally на тот случай если выбросится исключение */
        }
    }
    void skypeCall() {
        lock.lock(); // для закрытия замка монитора
        try {
            System.out.println("Skype call starts");
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // для открытия замка.
            /** unlock() пишется всегда в блоке finally на тот случай если выбросится исключение */
        }
    }
    void whatsAppCall() {
        lock.lock(); // для закрытия замка монитора
        try {
            System.out.println("WhatsApp call starts");
            Thread.sleep(7000);
            System.out.println("WhatsApp call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // для открытия замка.
            /** unlock() пишется всегда в блоке finally на тот случай если выбросится исключение */
        }
    }
}