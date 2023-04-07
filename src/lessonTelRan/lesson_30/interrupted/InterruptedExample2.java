package lessonTelRan.lesson_30.interrupted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterruptedExample2 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = null;

                while ((line = reader.readLine()).equals("0")) {
                    System.out.println("Read: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "Working");
        t.start();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread start interruption ... ");
        t.interrupt();
        System.out.println("Main thread is finish ... ");
    }
}
