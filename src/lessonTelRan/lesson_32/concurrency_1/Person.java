package lessonTelRan.lesson_32.concurrency_1;

import java.util.concurrent.Semaphore;

public class Person implements  Runnable{
    private String personName;
    private Semaphore semaphore;
    private boolean[] freeTable;

    public Person(String personName, Semaphore semaphore, boolean[] freeTable) {
        this.personName = personName;
        this.semaphore = semaphore;
        this.freeTable = freeTable;
    }
    @Override
    public void run() {
        System.out.println("-> " + personName + " подошёл в ресторан.");
        try {
            // запрашивается доступ, если доступ не разрешён - поток ожидает разрешения
            semaphore.acquire();
            int parkingNumber = 0;

            synchronized (freeTable) {
                for (int i = 0; i < 5; i++) {
                    if (!freeTable[i]) {

                        // определяем место как занятое
                        freeTable[i] = true;

                        // наличие занятого места гарантирует Semaphore
                        parkingNumber = i;

                        System.out.println("[!] " + personName + " был размещён за столиком # " + (i + 1));
                        break;
                    }
                }
            }
            // время на приготовления ланча и его завершение
            Thread.sleep(5000);
            synchronized (freeTable) {
                freeTable[parkingNumber] = false;
            }
            semaphore.release();
            synchronized (freeTable) {
                System.out.println("<- " + personName + " закончил свой ланч и покинул ресторан");
                System.out.println("[!] столик " + (parkingNumber + 1) + " освободился");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
