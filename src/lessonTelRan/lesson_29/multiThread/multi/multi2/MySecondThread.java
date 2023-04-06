package lessonTelRan.lesson_29.multiThread.multi.multi2;

public class MySecondThread extends Thread {
    @Override
    public void run() {
        long sum = 0;
        int counter = (int) (Math.random()*1000);
        for (int i = 0; i < counter; i++) {
            sum+= i;
        }
        System.out.println("Thread name is " + getName()
                + "  Counter= " + counter + "  Sum= " + sum);
        System.out.println(sum);
    }
}
