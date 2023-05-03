package udemy.multithreading.synchronizatory.semaphore;


import java.util.concurrent.Semaphore;

/**
        Semaphore - это синхронизатор, позволяющий ограничить доступ
    к какому-то ресурсу. В конструктор Semaphore нужно передавать количество
    потоков, которым Semaphore будет разрешать одновременно использовать
    этот ресурс. Методы acquire (эквайр), release (релиз).
 */
class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2); // две телефонные будки

        new Person("Zaur", callBox);
        new Person("Oleg", callBox);
        new Person("Elena", callBox);
        new Person("Marina", callBox);
    }
}
class Person extends Thread {
    String name;
    private Semaphore callBox;

    public Person (String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }
    public void run() {
        try {
            System.out.println(name + " ждёт... ");
            callBox.acquire(); // предназначен для получения разрешения от semaphore
            System.out.println(name + " пользуется телефоном");
            sleep(2000);
            System.out.println(name + " завершил(а) звонок");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            callBox.release(); //  освобождает для следующего потока
        }
    }
}