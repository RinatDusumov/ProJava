package algorithms._2023_02_17_Reference;

public class LambdaEx {
    public static void main(String[] args) {
        m1(() -> {
            System.out.println("*****");
            System.out.println("%%%%%");
            System.out.println("@@@@@");
        });
    }
    public static void m1 (Inter inter) {
        System.out.println("!!!!!");
        inter.go();
    }
}
@FunctionalInterface
interface Inter {
    void go();
}