package udemy.collection.vector.stack;
/*
    Stack - устаревший synchronized класс. Использует принцип LIFO
    (последний пришёл, первый вышел).
    Не рекомендован для использования.

 */
public class StackExample {
    public static void main(String[] args) {
        System.out.println("main starts");
        abc3();
        System.out.println("main ends");
    }
    static void  abc1() {
        System.out.println("abc starts");
        System.out.println("abc ends");
    }
    static void abc2() {
        System.out.println("abc2 starts");
        abc1();
        System.out.println("abc2 ends");
    }
    static void abc3() {
        System.out.println("abc3 starts");
        abc2();
        System.out.println("abc3 ends");
    }
}
