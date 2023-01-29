package lessonTelRan.lesson10;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> days = new LinkedHashSet<>();
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");

        Iterator itr = days.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
