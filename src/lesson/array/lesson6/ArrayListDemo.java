package lesson.array.lesson6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList <String> stringArrayList = new ArrayList<>();
        System.out.println(stringArrayList.size());

        stringArrayList.add("A");
        System.out.println(stringArrayList);

        String firstElement = stringArrayList.get(0);
        System.out.println(firstElement);

        addData(stringArrayList);
        System.out.println(stringArrayList);

        stringArrayList.trimToSize();
        for (String string : stringArrayList) {
            System.out.println(string);
        }
        Collections.sort(stringArrayList);
        System.out.println(stringArrayList);
    }
    public static void addData (List<String> workingCollection) {
        workingCollection.add("B");
        workingCollection.add("Ck");
        workingCollection.add("Grgh");
        workingCollection.add("Bek");
        workingCollection.add("VnB");
        workingCollection.add("Bc");
    }
}
