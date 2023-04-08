package udemy.multithreading;

public class ThreadEx1 {
    public static void main(String[] args) {
        MyThreadEx1 myThread = new MyThreadEx1();
        myThread.setName("moy_potok");
        myThread.setPriority(Thread.MAX_PRIORITY);
        //myThread.setPriority(7);

        System.out.println("Name of myThread = " + myThread.getName() +
                " Priority of myThread = " + myThread.getPriority());
    }
}
class MyThreadEx1 extends Thread {
    public void run() {
        System.out.println("Privet");
    }
}