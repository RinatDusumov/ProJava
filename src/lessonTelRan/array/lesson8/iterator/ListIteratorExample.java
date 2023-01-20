package lessonTelRan.array.lesson8.iterator;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();

        Cat murzik = new Cat("Murzik");
        Cat barsik = new Cat("Barsik");

        cats.add(murzik);
        cats.add(barsik);
        // -----------------

        ListIterator<Cat> catIterator = cats.listIterator();
        while (catIterator.hasNext()) {
            Cat tempCat = catIterator.next();
            if (tempCat.name.equals("Barsik")) {
                catIterator.remove();
                catIterator.add(new Cat("Burbon"));
            }
        }
        System.out.println(cats);

        while (catIterator.hasPrevious()) {
            System.out.println(catIterator.previous());
        }
        System.out.println(cats);
    }
}
