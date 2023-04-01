package algorithms._2023_02_17_Reference;

public class MethodRefEx {
    public static void main(String[] args) {
        m1(MethodRefEx::mr); // отправка в качестве параметра ссылки на реализацию метода
        // :: - квадроточие
    }

    public static void mr() {
        System.out.println("^^^^^^");
        System.out.println("@@@@@@");
        System.out.println("######");
    }

    public static void m1 (I inter) {
        System.out.println("!!!!!");
        inter.go();
    }
}
@FunctionalInterface
interface I {
    void go();
}