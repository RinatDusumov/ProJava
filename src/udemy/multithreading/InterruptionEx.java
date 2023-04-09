package udemy.multithreading;

/**
 *      Прерывание потоков
 *  У нас есть возможность послать сигнал потоку, что мы хотим его прервать.
 *  У нас также есть возможность в самом потоке проверить, хотят ли
 *  его прервать. Что делать, если данная проверка показала, что поток
 *  хотят прервать, должен решать сам программист.
 *
 *  interrupt()     isInterrupted()
 */
public class InterruptionEx {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        //thread.stop(); // устаревший метод, который не используется

        thread.interrupt(); // main хочет прервать поток thread

        thread.join();
        System.out.println("Main ends");
    }
}
class InterruptedThread extends Thread {
    double sqrtSum = 0;
    public void run() {
        for (int i = 1; i < 1_000_000_000; i++) {
            if (isInterrupted()) { // проверка хотят ли прервать поток thread
                System.out.println("Поток хотят прервать");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}