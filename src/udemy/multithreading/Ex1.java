package udemy.multithreading;

/**
 * Многопоточность - это принцип построения программы, при котором
 * несколько блоков кода могут выполняться одновременно.
 *
 * Основные цели - производительность и выполнение сразу нескольких задач.
 *
 * Варианты создания:
 * Наследования от класса Thread
 *      class MyThread extends Thread  {public void run() {...}}
 *      new MyThread().start();
 * Имплементация интерфейса Runnable
 *      cldss MyRunnable implements Runnable { public void main {...}}
 *      new Thread (new MyRunnable()).start();
 *
 * Из-за того, что в Java отсутствует множественное наследование,
 * чаще используют второй вариант.
 *
 * Четыре состояния потока
 *      1- состояние New (новый), до вызова метода start()
 *      2- после вызова start(), переход в состояние Runnable (состояние выполнения)
 *          1- ready (готовность), поток ждёт запуска от ОС -> 2- running (выполняется), после того как ОС запустит поток
 *      3- состояние Terminatet, когда работа потока завершена
 */
public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Privet");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println("Poka");
    }
}
