package lessonTelRan.lesson_20.reg_ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_Ex2 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[x-z]+");
        /** Поиск будет происходить от символа x до z включительно
            и только в нижнем регистре */
        Matcher matcher = pattern.matcher("x y z 1 2 3 4 5");
        System.out.println(matcher.find());

        Matcher matcher2 = pattern.matcher("A b Z 1 2 3 4 5");
        System.out.println(matcher2.find());
    }
}
