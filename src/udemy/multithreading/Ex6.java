package udemy.multithreading;

public class Ex6 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Privet");
            }
        }).start();
        // или
        new Thread(() -> {
            System.out.println("hello");
            sow();
        }
        ).start();
    }
    static void sow(){}
}