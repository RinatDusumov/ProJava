package lessonTelRan.lesson12.genericExamples2;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

public class Complex {
    void dump (Collection<Object> c) {
        for (Iterator<Object> i = c.iterator(); i.hasNext();) {
            Object o = i.next();
            System.out.println(o);
        }
    }

//    List<Object> l;
//    dump(l); // Ok
//
//    List<Integer> l;
//    dump(l); // Ошибка

    void dump2 (Collection<?> c) {
        for (Iterator<?> i = c.iterator(); i.hasNext(); ) {
            Object o = i.next();
            System.out.println(o);
        }
    }

//    void draw (List<Shape> c) {
//        for (Iterator<Shape> i = c.iterator(); i.hasNext(); ) {
//            Shape s = i.next();
//            s.draw();
//        }
//    }
//    List<Shape> l; draw(l); // ОК
//    List<Circle> l; draw(l); // Ошибка

//    void draw (List<? extends Shape> c) {
//        for (Iterator<? extends Shape> i = c.iterator(); i.hasNext(); ) {
//            Shape s = i.next();
//            s.draw;
//        }
//    }
}
