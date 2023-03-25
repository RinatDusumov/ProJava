package lessonTelRan.lesson_20.reg_ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_Ex3 {
    public static void main(String[] args) {
        String text = " Антон Александр Алла Андрей";
        Pattern pattern = Pattern.compile("A.+a");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }
    }
}