package udemy.generics;

import java.util.ArrayList;

public class ParameterizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> all = new ArrayList<>();
        // ArrayList all = new ArrayList<>(); для JVM
        int i = all.get(0);
        // JVM видит это так: int i = (Integer)all.get(0);


        all.add(10);
        all.add(20);
        all.add(5);
        int a = GenMethod.getSecondElement(all);
        System.out.println(a);

        ArrayList<String> all2 = new ArrayList<>();
        all2.add("ABC");
        all2.add("def");
        all2.add("sad");
//        String s = GenMethod.getSecondElement(all2);
//        System.out.println(a);
    }
}
class GenMethod {
    public static <T extends Number> T getSecondElement(ArrayList<T> al) {
        return al.get(1);
    }
}
