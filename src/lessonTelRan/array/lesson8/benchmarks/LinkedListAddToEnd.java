package lessonTelRan.array.lesson8.benchmarks;

import java.util.LinkedList;
import java.util.List;


public class LinkedListAddToEnd {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        System.out.println(integers.size());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            integers.size();
        }
        long finish = System.currentTimeMillis();
        long result = finish - start;

        System.out.println(integers.size());
        System.out.println("Result = " + result + " ms");
    }
}
