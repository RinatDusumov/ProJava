package lessonTelRan.array.lesson8.listDemo;

public class InputData {
    int count = 0;
    public Book inputNewBook() {
        count++;
        String name = "Book name " + count;
        Author author = new Author(0, "Author " + count);
        return new Book(count, author, name);
    }
    public int inputNumberOfElements() {

        return 10;
    }
}
