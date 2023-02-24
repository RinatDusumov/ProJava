package lessonTelRan.lesson14.setExamples;

import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class Example3 {
    public static void main(String[] args) {
        ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();
        set.add("Apple");
        set.add("Lemon");
        set.add("Banana");
        set.add("Apple");

        Iterator<String> itr = set.iterator();

        System.out.println("Fruits set: ");
        while (itr.hasNext()) {
            System.out.println(itr.next() + " ");
        }
    }
}
