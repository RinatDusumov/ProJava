package udemy.multithreading.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
        CountDownLatch - это синхронизатор, позволяющий любому
    количеству потоков ждать пока не завершится определённое
    количество операций. В конструктор CountDownLatch нужно передавать
    количество операций, которые должны завершится, чтобы потоки
    продолжили свою работу. Методы await(), countDown(), getCount().
 */
class CountDownLatchExample {
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    private static void marketStaffIsOnPlace() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown(); // уменьшает счётчик на единицу
        System.out.println("CountDownLatch = " + countDownLatch.getCount()); // для получения значения счётчика
    }
    private static void everythingIsReady() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        countDownLatch.countDown();
        System.out.println("CountDownLatch = " + countDownLatch.getCount());
    }
    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown();
        System.out.println("CountDownLatch = " + countDownLatch.getCount());
    }
    public static void main(String[] args) throws InterruptedException {
        new Friend("Zaur", countDownLatch).start();
        new Friend("Oleg", countDownLatch).start();
        new Friend("Elena", countDownLatch).start();
        new Friend("Victor", countDownLatch).start();
        new Friend("Marina", countDownLatch).start();

        marketStaffIsOnPlace();
        everythingIsReady();
        openMarket();

    }
}
class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;
    public Friend (String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch= countDownLatch;
        this.start();
    }
    public void run() {
        try {
            countDownLatch.await(); // если счётчик больше нуля поток будет заблокирован
                                    // если счётчик равен нулю, поток беспрепятственно выполнит работу
            System.out.println(name + " приступил(а) к закупкам");;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}