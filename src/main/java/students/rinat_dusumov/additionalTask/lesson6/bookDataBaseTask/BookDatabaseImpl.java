package main.java.students.rinat_dusumov.additionalTask.lesson6.bookDataBaseTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDatabaseImpl implements BookDatabase {
    static List<Book> books = new ArrayList<>();
    static Book book4 = new Book("A4", "B4");
    public static void main(String[] args) {
        BookDatabaseImpl bookDatabase = new BookDatabaseImpl();
        bookDatabase.save(book4);
        //boolean deleteBook = bookDatabase.delete(book4.getId());

        System.out.println(books);
        //System.out.println(deleteBook);

        final Optional<Book> optBook = bookDatabase.findById(books.get(0).getId());
        if (optBook.isPresent()) {
            final Book elBook = optBook.get();
            final String firstTitle = elBook.getTitle();
            if (firstTitle != null) {
                System.out.println("Название этой книги: " + firstTitle);
            }
        }
    }
    @Override
    public Long save(Book book) {
        Long idBook = Long.valueOf(0);
        books.add(book);
        for (int i = 0; i < books.size(); i++) {
            idBook = Long.valueOf(i + 1);
            book.setId(idBook);
        }
        return idBook;
    }

    @Override
    public boolean delete(Long bookId) {
        for (Book el : books) {
            if (el.getId() == bookId) {
                books.remove(el);
                System.out.println(books);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Book> findById(Long bookId) {

        return null;
    }
}