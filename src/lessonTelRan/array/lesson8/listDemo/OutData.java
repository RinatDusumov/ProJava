package lessonTelRan.array.lesson8.listDemo;

import java.util.List;

public class OutData {
    public void printOurCollection(List<Book> ourCollection) {
        System.out.println("Our collection: ");
        for (Book book : ourCollection) {
            System.out.println(book);
        }
    }
}
