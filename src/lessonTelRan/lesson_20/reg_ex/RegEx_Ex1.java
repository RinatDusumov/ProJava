package lessonTelRan.lesson_20.reg_ex;

import java.util.Arrays;

public class RegEx_Ex1 {
    public static void main(String[] args) {
        String text = "Java, The best program language in the world";
//        String[] words = text.split(" ");

        String[] words = text.split("\\s*(\\s|,|!|\\.)\\s*");
        System.out.println(Arrays.toString(words));
    }
}
