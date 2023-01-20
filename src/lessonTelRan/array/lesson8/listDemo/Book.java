package lessonTelRan.array.lesson8.listDemo;

public class Book {
    int bookId;
    Author author;
    String nameOfBook;

    public Book (int bookId, Author author, String nameOfBook) {
        this.bookId = bookId;
        this.author = author;
        this.nameOfBook = nameOfBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", author=" + author +
                ", nameOfBook='" + nameOfBook + '\'' +
                '}';
    }
}
