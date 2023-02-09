package main.java.students.rinat_dusumov.additionalTask.lesson12.bookDataBaseTask;

import java.util.List;
import java.util.Map;

public interface BookDatabase {
    Map<String, List<Book>> getAuthorToBooksMap();
}
