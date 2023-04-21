package lessonTelRan.lesson_31.synchronize;

class Example1 {
    static int counter;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                counter = 0;
                for (int i = 0; i < 5; i++) {
                    counter +=1;
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                }
            }
        };
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();
    }
}
