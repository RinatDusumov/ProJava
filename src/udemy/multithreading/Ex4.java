package udemy.multithreading;

public class Ex4 extends Thread {
    public void run() {
        for (int i = 0; i <= 1_000; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Ex4 thread1 = new Ex4();
        thread1.start();

        for (int i = 1_000; i > 0; i--) {
            System.out.println(i);
        }
    }
}
