package lessonTelRan.lesson_24.lessoncode;

import java.util.ArrayList;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("abcd");

        List<String> secondList = new ArrayList<>(myList);
        System.out.println(secondList);

        List<String> listCopy = new ArrayList<>();
        listCopy.addAll(0, myList);

        System.out.println(myList.get(0));
    }
}
