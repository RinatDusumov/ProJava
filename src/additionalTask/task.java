package additionalTask;

import java.io.PrintStream;
import java.util.ArrayList;

public class task {
    public static void main(String[] args) {
        String string = "aaa1 world aaa3 aaa4 aaa3 world aaa4 aaa8 aaa8 world aaa4 world aaa11 aaa14 aaa4 aaa7 aaa4 aaa9 aaa4 aaa10 aaa4 aaa11";
        findMostFrequentWord(string);
        System.out.println(findMostFrequentWord(string));
    }

    public static String findMostFrequentWord(String text) {
        String[] str = text.split(" ");
        ArrayList<String> arrayNumber = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            for (int j = 1; j < str.length; j++) {
                if (str[i].equalsIgnoreCase(str[j])) {

                }
            }
        }
        System.out.println();
        return null;
    }
}
