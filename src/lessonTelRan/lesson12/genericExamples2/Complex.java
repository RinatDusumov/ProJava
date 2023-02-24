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

//    List<Object> bbubk;
//    dump(bbubk); // Ok
//
//    List<Integer> bbubk;
//    dump(bbubk); // Ошибка

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
//    List<Shape> bbubk; draw(bbubk); // ОК
//    List<Circle> bbubk; draw(bbubk); // Ошибка

//    void draw (List<? extends Shape> c) {
//        for (Iterator<? extends Shape> i = c.iterator(); i.hasNext(); ) {
//            Shape s = i.next();
//            s.draw;
//        }
//    }
}
