package lessonTelRan.lesson_29.multiRunnable.multi3;

public class Car implements Runnable {
    private final String model;

    public Car(String model) {
        this.model = model;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Car " + model +
                "is being driven by thread " + Thread.currentThread().getName());
    }
}
