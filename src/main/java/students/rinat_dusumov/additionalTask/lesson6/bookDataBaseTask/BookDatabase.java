package main.java.students.rinat_dusumov.additionalTask.lesson6.bookDataBaseTask;

import java.util.Optional;

public interface BookDatabase {
    Long save (Book book);
    boolean delete(Long bookId);
    Optional<Book> findById(Long bookId);
}
