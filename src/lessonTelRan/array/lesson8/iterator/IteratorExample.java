package lessonTelRan.array.lesson8.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();

        Cat murzik = new Cat("Murzik");
        Cat barsik = new Cat("Barsik");
        Cat begemot = new Cat("Begemot");

        cats.add(murzik);
        cats.add(barsik);
        cats.add(begemot);

        System.out.println(cats.toString());

        Iterator<Cat> catIterator = cats.iterator();
        while (catIterator.hasNext()) {
            System.out.println(catIterator.next());
        }

        Iterator<Cat> catIterator2 = cats.iterator();
        while (catIterator2.hasNext()) {
            Cat tempCat = catIterator2.next();
            if (tempCat.name.equals("Begemot")) {
                System.out.println("equal");
                catIterator2.remove();
            }
        }
        System.out.println(cats);
    }
}
