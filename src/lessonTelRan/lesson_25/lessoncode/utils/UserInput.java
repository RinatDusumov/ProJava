package lessonTelRan.lesson_25.lessoncode.utils;

import java.util.Scanner;

public class UserInput {
    Scanner scr = new Scanner(System.in);
    public int inputInt(String message) {
        System.out.println(message);
        return scr.nextInt();
    }
    public String inputLine(String message) {
        System.out.println(message);
        return scr.nextLine();
    }
}

