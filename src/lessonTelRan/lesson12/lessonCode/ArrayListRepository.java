package lessonTelRan.lesson12.lessonCode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class ArrayListRepository implements  StringRepository {
    private List<String> dataBase = new ArrayList<>();

    @Override
    public void save(String text) {
        dataBase.add(text);
    }

    @Override
    public String toString() {
        return "ArrayListRepository{" +
                "dataBase=" + dataBase +
                '}';
    }
}
