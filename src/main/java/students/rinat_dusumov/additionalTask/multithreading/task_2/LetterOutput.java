package main.java.students.rinat_dusumov.additionalTask.multithreading.task_2;

class LetterOutput implements Runnable {

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread_2 = new Thread(new LetterOutput());
        Thread thread_3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    letter_C_output();
                }
            }
        });
        thread_2.start();
        thread_3.start();

        for (int i = 0; i < 5; i++) {
            letter_A_output();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            letter_B_output();
        }
    }

    static void letter_A_output() {
        synchronized (lock) {
            System.out.print("A");
            try {
                lock.wait(1400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void letter_B_output() {
        synchronized (lock) {
            System.out.print("B");
            try {
                lock.wait(1450);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static void letter_C_output() {
        synchronized (lock) {
            System.out.print("C");
            try {
                lock.wait(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}