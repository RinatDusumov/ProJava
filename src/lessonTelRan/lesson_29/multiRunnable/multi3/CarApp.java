package lessonTelRan.lesson_29.multiRunnable.multi3;

public class CarApp {
    public static void main(String[] args) {
        var ferrari = new Car("Ferrari");
        var bmw = new Car("BMW");

        var ferrariThread = new Thread(ferrari, "Ferrai -Thread");
        var bmwThread = new Thread(bmw, "BMW -Thread");

        ferrariThread.start();
        bmwThread.start();

        System.out.println("Method continues execution ... " +
                "Main method is executed by thread " + Thread.currentThread().getName());
    }
}
