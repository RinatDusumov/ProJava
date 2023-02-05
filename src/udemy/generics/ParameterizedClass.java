package udemy.generics;
/*
    E - элементы; K - ключи; V - значения;
 */
public class ParameterizedClass {
    public static void main(String[] args) {
//        Info<String> info1 = new Info<>("privet"); // <> - даймонд
//        System.out.println(info1);
//        String s = info1.getValue();

//        Info<Integer> info2 = new Info<>(18);
//        System.out.printf(String.valueOf(info2));
//        Integer i1 = info2.getValue();

//    public void abc (Info<String> info) {
//        String s = info.getValue();
//    }
//    public void abc (Info<Integer> info) {
//        Integer i = info.getValue();
//    }
        // JVM видит эти методы одинаковыми т.к. типы стираются - abc (Info info)


//        Info<Bus> info3 = new Info<>(new Bus());
//        System.out.println(info3);
//        Bus b1 = info3.getValue();
    }
}
class Info<T extends Number & I1 & I2> { // для ограничевания <T>.
    // через & добавляется имплементация(реализация) интерфейсов
    private T value;
    public Info (int value) {
        //this.value = value;
    }
    public String toString() {
        return "{[" + value + "]}";
    }
    public T getValue() {
        return value;
    }
}
interface I1{}
interface I2{}
//class Parent {
//    public void abc (Info<String> info) {
//        String s = info.getValue();
//    }
//}
//class Child extends Parent {
//    public void abc(Info<Integer> info) {
//        Integer i = info.getValue();
//    }
//}

// class Bus { }