package lessonTelRan.lesson_23.lessonCode;

import java.util.Arrays;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append(true);
        sb.append(",");
        sb.append(Arrays.asList(1,2,3,4,5));
        sb.append("!");

        System.out.println(sb);
    }
}
