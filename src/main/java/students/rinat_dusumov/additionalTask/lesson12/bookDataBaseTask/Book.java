package main.java.students.rinat_dusumov.additionalTask.lesson12.bookDataBaseTask;

import java.util.Objects;

public class Book {
    private String title;
    private String author;

    Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", author='" + author + '\'' +
                "title='" + title + '\'' +
                '}';
    }
}
