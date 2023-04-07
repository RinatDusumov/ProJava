package lessonTelRan.lesson_30.interrupted;

public class InterruptedExample3 implements Runnable {
    private volatile boolean stop;
    public void run() {
        while (!stop) {
            System.out.println("Thread is running");
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
                stop = true;
            }
        }
    }
    public void stopThread() {
        stop =true;
    }
    public static void main(String[] args) {
        InterruptedExample3 interruptedExample = new InterruptedExample3();
        Thread tr = new Thread(interruptedExample);
        tr.start();
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        interruptedExample.stopThread();
    }
}