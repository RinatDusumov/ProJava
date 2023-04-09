package udemy.multithreading.daemon;

/**
 * DaemonExample потоки предназначены для выполнения фоновых задач
 * и оказания различных сервисов User потокам (второстепенным)
 *
 * При завершении работы последнего User потока, программа завершает
 * своё выполнение, не дожидаясь окончания работы DaemonExample потоков.
 *
 * Создание с помощью метода setDaemon(true) перед запуском потока
 * Проверка является ли поток DaemonExample через метод isDaemon().
 */
class DaemonExample {
    public static void main(String[] args) {
        System.out.println("Main thread starts");
        UserThread ut = new UserThread();
        ut.setName("User_Thread");

        DaemonThread dt = new DaemonThread();
        dt.setName("Daemon_Thread");
        dt.setDaemon(true);

        ut.start();
        dt.start();

        System.out.println("Main thread ends");
    }
}
class UserThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getState() +
                " is daemon: " + isDaemon());
        for (char i = 'A'; i <= 'J'; i++) {
            try {
                sleep(3000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DaemonThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getState() +
                " is daemon: " + isDaemon());
        for (int i = 1; i <= 1_000; i++) {
            try {
                sleep(3000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}