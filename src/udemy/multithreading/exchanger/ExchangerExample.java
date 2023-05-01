package udemy.multithreading.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
        Exchanger - это синхронизатор, позволяющий обмениваться
    данными между двумя потоками (одного типа), обеспечивает то,
    что оба потока получат информацию друг от друга одновременно.
    Для обмена используется метод exchange().
 */
class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();

        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.NOJNICI);
        friend1Action.add(Action.BUMAGA);
        friend1Action.add(Action.KAMEN);

        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.BUMAGA);
        friend2Action.add(Action.KAMEN);
        friend2Action.add(Action.KAMEN);

        new BestFriend("Vanya", friend1Action, exchanger);
        new BestFriend("Petya", friend2Action, exchanger);
    }
}
enum Action {
    KAMEN,
    NOJNICI,
    BUMAGA
}
class BestFriend extends Thread {
    private String name;
    private List<Action> myAction;
    private Exchanger<Action> exchanger;

    public BestFriend (String name, List<Action> myAction, Exchanger<Action> exchanger) {
        this.name = name;
        this.myAction = myAction;
        this.exchanger = exchanger;
        this.start();
    }
    private void whoWins (Action myAction, Action friendAction) {
        if ((myAction == Action.KAMEN && friendAction == Action.NOJNICI)
        || (myAction == Action.NOJNICI && friendAction == Action.BUMAGA)
        || (myAction == Action.BUMAGA && friendAction == Action.KAMEN)) {
            System.out.println(name + " WINS!");
        }
    }
    public void run() {
        Action reply; // ответ от второго потока
        for (Action action : myAction) {
            try {
                reply = exchanger.exchange(action); // до того момента пока ответ не будет получен,
                                                    // поток вызывающий exchange() блокируется
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}