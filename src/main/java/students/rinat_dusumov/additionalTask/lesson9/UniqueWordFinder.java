package main.java.students.rinat_dusumov.additionalTask.lesson9;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueWordFinder {
    static Scanner scr = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Напишите текст");
        String text = scr.nextLine();

        System.out.println(find(text));
    }

    static Set<String> find (String text) {
        String[] textArray = text.split(" ");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < textArray.length; i++) {
            set.add(textArray[i]);
        }
        return set;
    }
}