package lessonTelRan.lesson_29.joinExample;

public class App1 {
    public static void main(String[] args) throws InterruptedException {
        var threadTwo = new Thread(() -> {
           try {
               Thread.sleep(2000);
               int counter = 0;
               for (int i = 0; i < 1000; i++) {
                   counter++;
               }
               var thread = Thread.currentThread().getName();
               System.out.println(thread + " has finished its execution, counter = " + counter);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }, "Counter thread");
        threadTwo.start();
        threadTwo.join();
        // основной поток main переходит в ожидание и ждёт пока поток
        // threadTwo не завершит работу
        System.out.println("Main method executing");
    }
}
