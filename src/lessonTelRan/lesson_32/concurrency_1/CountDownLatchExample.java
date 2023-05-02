package lessonTelRan.lesson_32.concurrency_1;

// Пример применения CountDownLatch в процессе отправления людей в отпуск, у нас 8 человек, которые
// желают отправиться в отпуск. В аэропорту они выполняют обычные действия, такие как регистрация,
// сдача багажа. Делают они это по отдельности, а после этого уже группой садятся в самолет и вылетают


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {
    public static void main(String[] args) throws Exception {


        // список людей, кто желает полететь на отдых
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        CountDownLatch countDownLatch = new CountDownLatch(personNames.length);

        for (int i = 0; i < personNames.length; i++) {
            new Thread(new PersonInAirport(personNames[i], countDownLatch)).start();
            Thread.sleep(1000);
        }

        int numPassengers = 10; // Количество пассажиров
        int numPermits = 5; // Количество разрешений Semaphore

        Semaphore semaphore = new Semaphore(numPermits);

        for (int i = 1; i <= numPassengers; i++) {
            String personName = "Пассажир " + i;
            PersonInAirport2 person = new PersonInAirport2(personName, semaphore);
            Thread thread = new Thread(person);
            thread.start();
        }
    }
}
class PersonInAirport implements Runnable {
    private String personName;
    private CountDownLatch countDownLatch;

    public PersonInAirport(String personName, CountDownLatch countDownLatch) {
        this.personName = personName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            // список дел, которые буду выполнены в рамках каждого потока (человека) самостоятельно
            System.out.println("-> " + personName + " приехал в аэропорт.");
            System.out.println("[!] " + personName + " сдал багаж");
            System.out.println("[!] " + personName + " пошел перекусить");

            countDownLatch.countDown();

            System.out.println("Count = " + countDownLatch.getCount());
            System.out.println();
            countDownLatch.await(3, TimeUnit.MINUTES); // ожидание всей группы



            // финальное - выполнится то, что находится после await() метода
            System.out.println(personName + " группой вылетел на отдых");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class PersonInAirport2 implements Runnable {
    private String personName;
    private Semaphore semaphore;

    public PersonInAirport2(String personName, Semaphore semaphore) {
        this.personName = personName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            // список дел, которые буду выполнены в рамках каждого потока (человека) самостоятельно
            System.out.println("-> " + personName + " приехал в аэропорт.");
            System.out.println("[!] " + personName + " сдал багаж");
            System.out.println("[!] " + personName + " успел перекусить");

            semaphore.acquire(); // Запрашиваем разрешение

            // фраза о вылете группой
            System.out.println(personName + " группой вылетел на отдых");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Освобождаем разрешение
        }
    }
}