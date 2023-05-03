package udemy.multithreading.threadPool.callable_future;

import java.util.concurrent.*;

/**
        Callable, так же как и Runnable, представляет собой определённое
    задание, которое выполняется потоком.
    В отличие от Runnable, Callable:
        имеет return type (не void)
        может выбрасывать Exception

        Метод submit() передаёт наше задание (task) в thread pool,
    для выполнения его одним из потоков, и возвращает тип Future,
    в котором и хранится результат выполнения нашего задания.

        Метод get() позволяет получить результат выполнения нашего
    задания из объекта Future (Фьючер).
 */
public class CallableFactorial {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(5);

        // также как метод execute(), только для интерфейса Callable
        Future<Integer> future = executorService.submit(factorial2);
        try {
            System.out.println(future.isDone()); // isDone() проверяет завершена ли задача, возвращает boolean
            System.out.println("Хотим получить результат");
            factorialResult = future.get(); // поток блокируется пока задача не будет решена

            System.out.println("Получили результат");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }
        finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult);
    }
}

class Factorial2 implements Callable<Integer> {
    int f;
    public Factorial2 (int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Неверное число");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
            Thread.sleep(1000);
        }
        return result;
    }
}