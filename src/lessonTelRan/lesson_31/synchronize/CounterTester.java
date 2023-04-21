package lessonTelRan.lesson_31.synchronize;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class CounterTester {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        for (int i = 0; i < 200; i++) {
            CounterThread ct = new CounterThread();
            ct.start();
        }
        Thread.sleep(1_000);
        System.out.println("Counter - " + counter.getCounter());
    }
}

class Counter {
    private static long counter = 0;

    //        synchronized public static void increaseCounter() {
//        counter++;
//    }
    static final Counter counter_class = new Counter();

    public static void increaseCounter() {
        synchronized (counter_class) {
            counter++;
        }
        /**
         Атомарные классы альтернатива ключевому слову synchronized.
         final AtomicLong c = new AtomicLong(counter);
         c.incrementAndGet();
         counter = c.get();
         */
    }

    public long getCounter() {
        return counter;
    }
}

class CounterThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1_000; i++) {
            Counter.increaseCounter();
        }
    }
}