package lessonTelRan.lesson_28.multithreading;

// Thread - нить, новый поток
public class UseThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("Hello world");
                    System.out.println("Finish thread");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        // закончилось описание создания нового потока
        // ниже запуск выполнения кода
        System.out.println("Start program");
        System.out.println("Pause 5 sec");
        thread.start();
        System.out.println("Finish program");
    }
}