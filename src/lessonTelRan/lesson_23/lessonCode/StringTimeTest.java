package lessonTelRan.lesson_23.lessonCode;

public class StringTimeTest {
    public static void main(String[] args) {
        String str = "";

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            str = str + i;
        }
        long finish = System.currentTimeMillis();
        System.out.println("Operations time is " + (finish - startTime));

        StringBuilder sb = new StringBuilder();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            sb.append(i);
        }
        finish = System.currentTimeMillis();
        System.out.println("Operation time is " + (finish - startTime));
    }
}
