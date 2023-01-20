package lessonTelRan.array.lesson8.listDemo;

import java.util.LinkedList;
import java.util.List;

public class CollectionsUtil {
    public List<Book> createCollection() {
        return new LinkedList<>();
    }
    public void fillCollection(List<Book> ourCollection, int sizeOurCollection, InputData inputData, boolean addInHead) {
        for (int i = 0; i < sizeOurCollection; i++) {
            Book newBook = inputData.inputNewBook();
            addElementInToOurCollection(ourCollection, addInHead, newBook);
        }
    }
    public void addElementInToOurCollection(List<Book> ourCollections, boolean addInHead, Book newBook){
        if(addInHead) {
            ourCollections.add(0, newBook);
        } else {
            ourCollections.add(newBook);
        }
    }
    public Book searchBook(List<Book> ourCollections, String searchCriteria) {
        return null;
    }
    public void deleteOurBook(List<Book> ourCollections, Book bookForDelete) {

    }
    public List<Book> createCollectionDublicate(List<Book> ourCollections) {
        return null;
    }
    public void sortOurCollectionDublicate(List<Book> ourCollection, boolean isGrow) {

    }
 }
