package udemy.multithreading.wait_notify;

/**
    Для извещения потоком других потоков о своих действиях часто
 используются следующие методы:
  wait() - освобождает монитор и переводит вызывающий поток в состояние
 ожидания до тех пор, пока другой поток не вызовет метод notify();
  notify() - НЕ освобождает монитор и будит поток, у которого ранее был
 вызван метод wait();
  notifyAll() - НЕ освобождает монитор и будит все потоки, у которых
 ранее был вызван метод wait();
 */
public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}
class Market {
    private int breadCount = 0;
    private final Object lock = new Object();
    //public synchronized void getBread() {
    public void getBread() {
        synchronized (lock) {
            // согласно javadoc рекомендовано использование именно while
            while (breadCount < 1) {
                try {
                    lock.wait(1_000); // столько времени поток будет ждать вызова метода notify()
                    /**
                     * на мониторе какого объекта делаю синхронизацию,
                     * на том же самом объекте нужно вызывать методы
                     * wait и notify.
                     */
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            breadCount--;
            System.out.println("Потребитель купил 1 хлеб");
            System.out.println("Количество хлеба в магазине = " + breadCount);
            lock.notify();
        }
    }
    public synchronized void putBread() {
        while (breadCount >= 5) {
            try {
                wait(); // то же самое что this.wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Количество хлеба в магазине = " + breadCount);
        notify(); // то же самое что this.notify
    }
}
class Producer implements Runnable {
    Market market;
    Producer(Market market) {
        this.market = market;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}
class Consumer implements Runnable {
    Market market;
    Consumer(Market market) {
        this.market = market;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}