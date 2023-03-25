package lessonTelRan.lesson17.library;

public class AppLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        LibraryUtils lUtils = new LibraryUtils();

        lUtils.printBooks(lUtils.doWithLambda(library.getBooks()));

        System.out.println("==================");

        lUtils.printBooks(library.getBooks());

//        System.out.println(library.getBooks());
//        System.out.println(library.getReaders());
    }
}