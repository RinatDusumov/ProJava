package main.java.students.rinat_dusumov.additionalTask.lesson6.bookDataBaseTask;

import java.util.Objects;

// Дан класс Book:
public class Book {
    private Long id;
    private String title;
    private String author;

    Book (String author, String title) {
        this.author = author;
        this.title = title;
    }
    public void setId (Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}