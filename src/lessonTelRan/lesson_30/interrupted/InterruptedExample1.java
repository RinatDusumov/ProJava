package lessonTelRan.lesson_30.interrupted;

public class InterruptedExample1 {
    public static void main(String[] args) {
        Thread tr = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Working ... ");
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Working");
        tr.start();

        try {
            Thread.sleep(5_0000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tr.interrupt();
    }
}
