package main.java.students.rinat_dusumov.additionalTask.lesson12.bookDataBaseTask;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BookDatabaseImpl implements BookDatabase{

    public static void main(String[] args) {
        BookDatabaseImpl bookDatabaseImpl = new BookDatabaseImpl();
        bookDatabaseImpl.getAuthorToBooksMap();
    }
    @Override
    public Map<String, List<Book>> getAuthorToBooksMap() {

        return null;
    }

}
