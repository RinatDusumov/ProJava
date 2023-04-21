package lessonTelRan.lesson_31.object;

public class Crossbow {
    private int arrows = 10;

    synchronized public void fire() {
        for (int i = arrows; i >= 0; i--) {
            if (i != 0) {
                System.out.println("The arrow is " + (arrows - i + 1) + " right on the target!");
            } else {
                System.out.println("The arrows are over");
                arrows = 0;
                System.out.println("Count arrows " + arrows);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Carry a new quiver with arrows!");
            }
        }
    }
    synchronized public void reload() {
        System.out.println("New arrows on the way!");
        arrows = 10;
        System.out.println("Count arrows " + arrows);
        notify();
    }
}
class TestCrossbow extends Thread {
    public static void main(String[] args) {
        Crossbow crossbow = new Crossbow();
        new Thread(crossbow::fire).start();
        new Thread(crossbow::reload).start();
    }
}