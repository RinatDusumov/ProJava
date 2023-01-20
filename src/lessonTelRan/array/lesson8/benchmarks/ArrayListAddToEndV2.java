package lessonTelRan.array.lesson8.benchmarks;

import java.util.ArrayList;
import java.util.List;

public class ArrayListAddToEndV2 {
    public static void main(String[] args) {
        runBenchmakr();
    }
    private static void runBenchmakr() {
        List<Integer> integers = new ArrayList<>();
        System.out.println(integers.size());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 300_000; i++) {
            integers.add(i);
        }
        long finish = System.currentTimeMillis();
        long result = finish = start;

        System.out.println(integers.size());
        System.out.println("Result = " + result + " ms");
    }
}
