package lessonTelRan.lesson12.lessonCode;

import java.util.Scanner;

public class StringApplication {
    public static void main(String[] args) {
        ArrayListRepository database = new ArrayListRepository();
        Scanner scr = new Scanner(System.in); // Scanner только отладочный механизм

        System.out.println("Please enter numbers of elements: ");
        int userInputElements = scr.nextInt();
        scr.nextLine(); // для того чтобы после nextInt считать с консоли nextLine

        for (int i = 0; i < userInputElements; i++) {
            System.out.println("Please enter " + i + " database element: ");
            String userInput = scr.nextLine();
            database.save(userInput);
        }
    }
}
