package main.java.students.rinat_dusumov.additionalTask.lesson12.bookDataBaseTask;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWordFinder {
    static Set<String> setText = new HashSet<>();
    static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Напишите текст");
        String userText = scr.nextLine();

        UniqueWordFinder uniqueWordFinder = new UniqueWordFinder();
        uniqueWordFinder.find(userText);

        System.out.println(setText);
    }
    Set<String> find (String text) {
        String[] userTextArray = text.split(" ");
        for (String str : userTextArray) {
            setText.add(str);
        }
        return setText;
    }
}
