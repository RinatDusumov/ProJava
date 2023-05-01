package udemy.multithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
    Thread pool - это множество потоков, каждый из которых предназначен для выполнения
 той или иной задачи.
    В Java с thread pool-ами удобнее всего работать посредством интерфейса ExecutorService
 (Executor - исполнитель).
    Thread pool удобнее всего создавать, используя factory методы класса Executors:
 Executors.newFixedThreadPool(int count) - создаст pool с 5-тью потоками;
 Executors.newSingleThreadExecutor() - создаст pool с одним потоком.

    Метод execute передаёт наше задание (task) в thread pool,
 где оно выполняется одним из потоков.
    После выполнения метода shutdown ExecutorService понимает, что
 новых заданий больше не будет и, выполнив поступившие до этого
 задания, прекращает работу.

    Метод awaitTermination принуждает поток в котором он вызвался
 подождать до тех пор, пока не выполнится одно их двух событий
 либо ExecutorService прекратит свою работу,
 либо пройдёт время, указанное в параметре метода awaitTermination.


 Если в программе необходимо ограничение потоков
 */
public class ThreadPoolEx1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImp100());
        }
        executorService.shutdown(); // останавливает программу после выполнения всех полученных задач
        executorService.awaitTermination(5, TimeUnit.SECONDS); // практически как метод join()
        System.out.println("Main ends");
    }
}
class RunnableImp100 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}