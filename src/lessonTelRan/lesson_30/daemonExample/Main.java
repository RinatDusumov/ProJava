package lessonTelRan.lesson_30.daemonExample;

public class Main {
    public static void main(String[] args) {
        DaemonExample saver = new DaemonExample();
        Thread tr = new Thread(saver);
        tr.setDaemon(true); // устанавливаем флаг daemon
        tr.start(); // запускаем поток
    }
}