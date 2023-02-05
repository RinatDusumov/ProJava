package main.java.students.rinat_dusumov.additionalTask.lesson9;

import java.util.HashSet;
import java.util.Set;

import static main.java.students.rinat_dusumov.additionalTask.lesson9.UniqueWordFinder.find;

public class UniqueWordFinderTest {
    public static void main(String[] args) {
        String text = "aaa bb cccc cccc aa cdba dsac aa";

        Set<String> expectedResult = new HashSet<>();
        expectedResult.add("aaa");
        expectedResult.add("bb");
        expectedResult.add("cccc");
        expectedResult.add("aa");
        expectedResult.add("cdba");
        expectedResult.add("dsac");

        Set<String> realResult = find(text);

        if (expectedResult.size() == realResult.size()) {
            System.out.println("all words are unique");
        } else {
            System.out.println("not all words are unique");
        }
    }
}