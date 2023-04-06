package lessonTelRan.lesson_29.multiThread.multi;

public class MyFirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm Thead! My name is " + getName());
    }

}