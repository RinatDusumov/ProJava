package lessonTelRan.lesson_32.concurrency_1;
import java.util.concurrent.Phaser;

/**
        Итак, здесь у нас фазы выполняются тремя участниками - главным потоком и двумя потоками PhaseThread.
    Поэтому при создании объекта Phaser ему передается число 1 - главный поток, а в конструкторе PhaseThread
    вызывается метод register(). Мы в принципе могли бы не использовать метод register, но тогда нам надо было
    бы указать Phaser phaser = new Phaser(3), так как у нас три участника.
        Фаза для каждого участника представляет минимальный примитивный набор действий: для потоков PhaseThread
    это вывод сообщения, а для главного потока - подсчет текущей фазы с помощью метода getPhase(). При этом отсчет
    фаз начинается с нуля. Каждый участник завершает выполнение фазы вызовом метода phaser.arriveAndAwaitAdvance().
    При вызове этого метода пока последний участник не завершит выполнение текущей фазы, все остальные участники
    блокируются.

        После завершения выполнения последней фазы происходит отмена регистрации всех участников с помощью
    метода arriveAndDeregister().
 */

public class PhaserExample2 {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        new Thread(new PhaseThread(phaser, "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser, "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}
class PhaseThread implements Runnable{

    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n){

        this.phaser=p;
        this.name=n;
        phaser.register();
    }
    public void run(){
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута
        try{
            Thread.sleep(200);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
    }
}