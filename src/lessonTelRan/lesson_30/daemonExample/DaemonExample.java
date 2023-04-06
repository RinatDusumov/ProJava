package lessonTelRan.lesson_30.daemonExample;

public class DaemonExample implements Runnable {
    public void run() {
        while (true) {
            try {
                Thread.sleep(600_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}