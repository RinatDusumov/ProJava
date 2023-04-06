package lessonTelRan.lesson_29.multiThread.multi.multi3;

public class CarApp {
    public static void main(String[] args) {
        var ferrari = new Car("Ferrari");
        var bmw = new Car("BMW");
        ferrari.start();
        bmw.start();

        System.out.println("Method continues execution ... " +
                "Main method is executed by thread " + Thread.currentThread().getName());
    }
}
