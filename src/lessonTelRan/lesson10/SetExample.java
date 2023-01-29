package lessonTelRan.lesson10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*      Hash code влияет на порядковое распределение внутри коллекции.
    в
 */
public class SetExample {
    public static void main(String[] args) {
        Set<String> days = new HashSet<>();

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
