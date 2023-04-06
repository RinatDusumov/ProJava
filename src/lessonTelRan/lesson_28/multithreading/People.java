package lessonTelRan.lesson_28.multithreading;

public class People extends Thread {
    private String[] names;
    private int numberThread;
    public int result;

    People(int numberThread, String... names) {
        this.names = names;
        this.numberThread = numberThread;
    }
    @Override
    public void run() {
        System.out.println("Start " + numberThread + " thread");
        for (int i = 0; i < names.length; i++) {
            System.out.println("Выдана путёвка: " + names[i]);
            try {
                sleep(500);
            } catch (Exception e) {}
        }
        System.out.println("Finish " + numberThread + " thread");
        result = names.length * numberThread;
    }
}