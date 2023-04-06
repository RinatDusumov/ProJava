package lessonTelRan.lesson_30;

public class App2 {
    public static void main(String[] args) {
        var worker = new Thread(() -> {
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           var threadName = Thread.currentThread().getName();
            System.out.println("Thread is finishing its execution with name: " + threadName);
        }, "Worker");

        var daemon = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                var threadName = Thread.currentThread().getName();
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread is finishing its execution with name: " + threadName);
                }
            }
        }, "Daemon");

        daemon.setDaemon(true); // таким образом создаётся фоновый поток (daemon), но только если поток не был запущен
        worker.start();
        daemon.start();

        double count = 0;
        var threadName = Thread.currentThread().getName();
        System.out.println("Thread is executing with name: " + threadName);
        for (int i = 1; i < 1_000_000; i++) {
            count = count + calc(i);
        }
        System.out.println("Thread is closing with name: " + threadName);
    }
    private static double calc (int i) {
        double calc = 1;
        for (int j = 1; j < i; j++) {
            calc = calc * j;
        }
        return calc;
    }
}