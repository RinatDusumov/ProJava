package udemy.multithreading.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
        Атомарная (греч. άτομος — неделимое) операция — операция, которая либо
    выполняется целиком, либо не выполняется вовсе; операция, которая не может
    быть частично выполнена и частично не выполнена.

        AtomicInteger - это класс, который предоставляет возможность
    работать с целочисленными значениями int, используя
    атомарные операции.
    incrementAndGet()
    getAndIncrement()
    addAndGet()
    getAndAdd()

    decrementAndGet()
    getAndDecrement()
    для использования addAndGet(-5)
                      getAndAdd(-5)
 */
public class AtomicIntegerExample {
//    static int counter = 0;
//    public synchronized static void increment() {
//        counter++;
//    }
    static AtomicInteger counter = new AtomicInteger(0);
    public static void increment() {
        //counter.incrementAndGet();
        counter.addAndGet(5); // увеличение на число указанное в параметре
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl());
        Thread thread2 = new Thread(new MyRunnableImpl());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter);
    }
}

class MyRunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            AtomicIntegerExample.increment();
        }
    }
}