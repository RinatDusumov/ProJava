package main.java.students.rinat_dusumov.additionalTask.multithreading.task_5;

class Counter implements Runnable {
    private static final Object lock = new Object();
    static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 101; i++) {
            sub();
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new Counter());
        thread.start();
        for (int i = 0; i < 100; i++) {
            add();
        }
    }

    static void add() {
        synchronized (lock) {
            System.out.println(count);
            count++;
        }
    }

    void sub() {
        if (count >= 0) {
            synchronized (lock) {
                System.out.println(count);
                count--;
            }
        }
    }
}