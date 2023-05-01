package udemy.multithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
    ScheduledExecutorService мы используем тогда, когда хотим
 установить расписание на запуск потоков из пула.
 Данный pool создаётся, используя factory метод класса Executors:
 Executors.newScheduledThreadPool(int count)
 */
public class ThreadPoolEx2 {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
//        for (int i = 0; i < 10; i++) {
//            scheduledExecutorService.execute(new RunnableImp200());
//        }

//        scheduledExecutorService.schedule(new RunnableImp200(), // выполнение каждые три секунды
//                3, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImp200(), // период между началом первого и началом следующего потока
//                3, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImp200(), // период между окончанием первого и началом следующего.
                3, 1, TimeUnit.SECONDS);

        Thread.sleep(20000);
        scheduledExecutorService.shutdown();


        // ThreadPool который будет создавать потоки по мере их надобности и удалять если они не требуются
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
class RunnableImp200 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}