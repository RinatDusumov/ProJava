package udemy.multithreading;

/**
    Data Race - это проблема, которая может возникнуть когда два и
    более потока обращаются к одной и той же переменной и как
    минимум 1 поток её изменяет.

    Ключевое слово synchronized устанавливает замок для остальных потоков
    до завершения работы.
    //public synchronized void abc() {method body}
 */
public class SynchroEx2 {
    static int counter = 0;

    public static synchronized void increment() {
        counter++;
        System.out.println(counter + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread tr = new Thread(new R(), "one thread");
        Thread tr2 = new Thread(new R(), "two thread");
        tr.start();
        tr2.start();

        tr.join();
        tr2.join();

        System.out.println(counter);
    }
}
class R implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            SynchroEx2.increment();
        }
    }
}